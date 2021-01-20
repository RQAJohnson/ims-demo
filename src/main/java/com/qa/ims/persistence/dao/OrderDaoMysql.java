package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Order;

public class OrderDaoMysql implements Dao<Order> {
	
	public static final Logger LOGGER = Logger.getLogger(ItemDaoMysql.class);
	private String jdbcConnectionUrl;
	private String username;
	private String password;  
	
	public OrderDaoMysql(String username, String password) {
		this.jdbcConnectionUrl = "jdbc:mysql://localhost:3306/ims";
		this.username = username;
		this.password = password; 
		
		}
	public OrderDaoMysql(String jdbcConnectionUrl, String username, String password) {
		this.jdbcConnectionUrl = jdbcConnectionUrl;
		this.username = username;
		this.password = password;
		}	
	Order orderFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderID = resultSet.getLong("orderID");
		Long customerID = resultSet.getLong("customerID");
		return new Order(orderID, customerID);
	}
	
	Order orderlineFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderID = resultSet.getLong("ol_orderID");
		Long itemID = resultSet.getLong("ol_itemID");
		return new Order(orderID, itemID);
	}

	@Override
	public List<Order> readAll() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");) {
			ArrayList<Order> order = new ArrayList<>();
			while (resultSet.next()) {
				order.add(orderFromResultSet(resultSet));
			}
			return order;
			
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Order readLatest() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY orderID DESC LIMIT 1");) {
			resultSet.next();
			return orderFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Order create(Order order) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("insert into orders(customerID) values(" + order.getCustomerID() + ")");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;	
	}
	
	public Order readOrder(Long orderID) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders where orderID = " + orderID);) {
			resultSet.next();
			return orderFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
		}
	
	public Order update(Order order) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("update orders set = orderID(" + order.getOrderID() 
			+ "' where id =" + order.getCustomerID());
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;	
	}
	
	public Order orderline(Order order) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("insert into orderline(ol_orderID, ol_itemID) values(" + order.getOrderID()
			+ "," + order.getItemID() + ")");
			return orderlinereadOrder();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		} 
//		String sql = "SELECT orderID" + 
//				"FROM orders" + 
//				"WHERE orderID = ?";
//		try (
//			Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
//				PreparedStatement preparedstatement = connection.prepareStatement(sql)) {
//				Long orderID = 4;
//				preparedstatement.setLong(1, orderID);
//			ResultSet rs = preparedstatement.executeQuery(sql);
//			
//	}
		
		return null;
		
	}
	
	public Order orderlinereadOrder() {
		Order order = new Order();
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT ol_orderID FROM orderline where orderID = (" 
				+ order.getOrderID() + ")")) {
			resultSet.next();
			return orderlineFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;	
	}
		
	@Override
	public void delete(long orderID) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("DELETE FROM orders where orderID = " + orderID);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		System.out.println("Order Deleted");
	}
	@Override
	public Customer update2() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Customer update() {
		// TODO Auto-generated method stub
		return null;
	}	

}
