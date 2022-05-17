package dao;

import model.Orders;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class for order insert query
 */
public class OrderDAO extends AbstractDAO<Orders> {

    /**
     * Constructor without parameters
     */
    public OrderDAO(){
        super();
    }

    /**
     * Method returns insert order query
     * @return String
     */
    public String createInsertQuery(){
        return "INSERT INTO orders (productName,clientName,quantity) VALUES(?,?,?)";
    }
    /**
     * Method to set the values for the insert into order statement
     * @param statement insert statement
     * @param order order to insert
     */
    public void setInsertValues(PreparedStatement statement, Orders order){
        try {
            statement.setString(1,order.getProductName());
            statement.setString(2,order.getClientName());
            statement.setInt(3,order.getQuantity());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
