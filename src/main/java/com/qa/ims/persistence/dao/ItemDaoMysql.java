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
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;

public class ItemDaoMysql implements Dao<Item> {
	
	public static final Logger LOGGER = Logger.getLogger(ItemDaoMysql.class);
	private String jdbcConnectionUrl;
	private String username;
	private String password;  
	
	public ItemDaoMysql(String username, String password) {
		this.jdbcConnectionUrl = "jdbc:mysql://localhost:3306/ims";
		this.username = username;
		this.password = password; 
		
		}
	public ItemDaoMysql(String jdbcConnectionUrl, String username, String password) {
		this.jdbcConnectionUrl = jdbcConnectionUrl;
		this.username = username;
		this.password = password;
		}

		Item itemFromResultSet(ResultSet resultSet) throws SQLException {
			Long itemID = resultSet.getLong("itemID");
			String title = resultSet.getString("title");
			Double price = resultSet.getDouble("price");
			return new Item(itemID, title, price);
		}

		@Override
		public List<Item> readAll() {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("select * from items");) {
				ArrayList<Item> item = new ArrayList<>();
				while (resultSet.next()) {
					item.add(itemFromResultSet(resultSet));
				}
				return item;
				
			} catch (SQLException e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return new ArrayList<>();
		}

		public Item readLatest() {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT * FROM items ORDER BY itemID DESC LIMIT 1");) {
				resultSet.next();
				return itemFromResultSet(resultSet);
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return null;
		}

		@Override
		public Item create(Item item) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();) {
				statement.executeUpdate("insert into items(title, price) values('" + item.getTitle()
						+ "','" + item.getPrice() + "')");
				return readLatest();
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return null;
		}

		public Item readItem(Long id) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT * FROM items where itemID = " + id);) {
				resultSet.next();
				return itemFromResultSet(resultSet);
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return null;
		}

		@Override
		public Item update(Item item) {
			String sqlUpdate = "UPDATE items "
	                + "SET title = ?, price = ? "
	                + "WHERE itemID = ?";
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					PreparedStatement pstmt = connection.prepareStatement(sqlUpdate)) { 
				
	            pstmt.setString(1, item.getTitle());
	            pstmt.setDouble(2, item.getPrice());
	            pstmt.setLong(3, item.getId());

	            int itemUpdated = pstmt.executeUpdate();
	            System.out.println(String.format("Item Updated!", itemUpdated));
	            
	            pstmt.close();
				
			}
			catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return null;
		}

		@Override
		public void delete(long id) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();) {
				statement.executeUpdate("DELETE FROM items where itemID = " + id);
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			System.out.println("Item Deleted");
		}
		@Override
		public Order orderline(Order order) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Customer update() {
			// TODO Auto-generated method stub
			return null;
		}
		
}
