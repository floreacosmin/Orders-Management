package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;
import model.Product;

/**
 * Class for product insert and oupdate query
 */
public class ProductDAO extends AbstractDAO<Product>{

    /**
     * Constructor without parameters
     */
    public ProductDAO(){
        super();
    }
    /**
     * Method returns insert into product query
     * @return String
     */
    public String createInsertQuery(){
        return "INSERT INTO product (name,quantity,price) VALUES(?,?,?)";
    }
    /**
     * Method returns insert into product query
     * @return String
     */
    public String createUpdateQuery(){
        return "UPDATE product SET name=?, quantity=?, price=? WHERE id=?";
    }
    /**
     * Method to set the values for the insert into product statement
     * @param statement insert statement
     * @param product product to insert
     */
    public void setInsertValues(PreparedStatement statement, Product product){
        try {
            statement.setString(1,product.getName());
            statement.setInt(2,product.getQuantity());
            statement.setInt(3,product.getPrice());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * Method to set the values for the update product statement
     * @param statement update statement
     * @param product product to update
     */
    public void setUpdateValues(PreparedStatement statement, Product product){
        try {
            statement.setString(1,product.getName());
            statement.setInt(2,product.getQuantity());
            statement.setInt(3,product.getPrice());
            statement.setInt(4,product.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
