package dao;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;

/**
 * Class for SQL query on the database
 * This class uses reflection
 */
public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(dao.AbstractDAO.class.getName());

    private final Class<T> type;


    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }

    /**
     * Create select query
     * @param field search parameter
     * @return String
     */
    private String createSelectQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE ");
        sb.append(field);
        sb.append(" =?");
        return sb.toString();
    }

    /**
     * Method will be override-ed in subclasses
     * @return null
     */
    public  String createInsertQuery(){
        return null;
    }

    /**
     * Method will be override-ed in subclasses
     * @return null
     */
    public  String createUpdateQuery(){
        return null;
    }


    /**
     * Method will be override-ed in subclasses
     * @param statement statement
     * @param t general object
     */
    public void setInsertValues(PreparedStatement statement, T t){ }

    /**
     * Method will be override-ed in subclasses
     * @param statement statement
     * @param t general object
     */
    public void setUpdateValues(PreparedStatement statement, T t){ }

    /**
     * Create delete query
     * @param field search parameter
     * @return String
     */
    private String createDeleteQuery(String field){
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE ");
        sb.append(field);
        sb.append(" =?");
        return sb.toString();
    }

    /**
     * Create findAll query
     * @return String
     */
    private String createFindAllQuery(){
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * ");
        sb.append("FROM ");
        sb.append(type.getSimpleName());
        return sb.toString();
    }

    /**
     * Method executes a findAll query on the database
     * @return List<T>
     */
    public List<T> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createFindAllQuery();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            return createObjects(resultSet);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Method executes a find by id query on the database
     * @param id search id
     * @return Object
     */
    public T findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(createSelectQuery("id"));
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }


    /**
     * Method executes a insert query on the database
     * @param t Object to be inserted
     * @return int
     */
    public int insert(T t) {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement insertStatement = null;
        ResultSet rs = null;
        int insertedId = -1;

        try {

            insertStatement = dbConnection.prepareStatement(createInsertQuery(), Statement.RETURN_GENERATED_KEYS);
            setInsertValues(insertStatement,t);
            insertStatement.executeUpdate();

            rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }
            return insertedId;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return -1;
    }

    /**
     * Method executes a update query on the database
     * @param t Object to be updated
     * @return int
     */
    public int update(T t) {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement updateStatement = null;
        ResultSet rs = null;
        int updatedId = -1;
        try {

            updateStatement = dbConnection.prepareStatement(createUpdateQuery(), Statement.RETURN_GENERATED_KEYS);
            setUpdateValues(updateStatement,t);
            updateStatement.executeUpdate();

            rs = updateStatement.getGeneratedKeys();
            if (rs.next()) {
                updatedId = rs.getInt(1);
            }
            return updatedId;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO:update " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(updateStatement);
            ConnectionFactory.close(dbConnection);
        }
        return -1;
    }

    /**
     * Method executes a delete query on the database
     * @param id search id
     * @return int
     */
    public int delete(int id) {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement deleteStatement = null;
        ResultSet rs = null;
        int deletedId = -1;

        try {

            deleteStatement = dbConnection.prepareStatement(createDeleteQuery("id"), Statement.RETURN_GENERATED_KEYS);
            deleteStatement.setInt(1, id);
            deleteStatement.executeUpdate();

            rs = deleteStatement.getGeneratedKeys();
            return deletedId;

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO:delete " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(dbConnection);
        }
        return -1;
    }

    /**
     * Method uses reflection to create an object from a resultSet
     * @param resultSet ResultSet
     * @return List<T>
     */
    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T)ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }


}
