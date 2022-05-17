package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;
import model.Client;

/**
 * Class for client insert and update query
 */
public class ClientDAO extends AbstractDAO<Client>{

	/**
	 * Constructor without parameters
	 */
	public ClientDAO(){
		super();
	}


	/**
	 * Method returns insert into client query
	 * @return String
	 */
	public String createInsertQuery(){
		return "INSERT INTO client (name,address,email,age) VALUES(?,?,?,?)";
	}

	/**
	 * Method returns update client query
	 * @return String
	 */
	public String createUpdateQuery(){
		return "UPDATE client SET name=?, address =?, email=?, age=? WHERE id=?";
	}

	/**
	 * Method to set the values for the insert into client statement
	 * @param statement insert statement
	 * @param client client to insert
	 */
	public void setInsertValues(PreparedStatement statement,Client client){
		try {
			statement.setString(1,client.getName());
			statement.setString(2,client.getAddress());
			statement.setString(3,client.getEmail());
			statement.setInt(4,client.getAge());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Method to set the values for the update client statement
	 * @param statement update statement
	 * @param client client to update
	 */
	public void setUpdateValues(PreparedStatement statement, Client client){
		try {
			statement.setString(1,client.getName());
			statement.setString(2,client.getAddress());
			statement.setString(3,client.getEmail());
			statement.setInt(4,client.getAge());
			statement.setInt(5,client.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
