package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.Ims;
import com.qa.ims.persistence.domain.Customer;

public class CustomerDaoMysqlTest {
	
	public static final Logger LOGGER = Logger.getLogger(CustomerDaoMysql.class);

	private static String jdbcConnectionUrl="jdbc:mysql://localhost:3306/ims_test";
	private static String username="root";
	private static String password="root";
	
	@BeforeClass
	public static void init() {
		Ims ims = new Ims();
		ims.init(jdbcConnectionUrl, username, password, "src/test/resources/sql-schema.sql");
	}
	
	@Before
	public void setup() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from customers");
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}
	
	@Test
	public void createTest() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(jdbcConnectionUrl, username, password);
		String fn = "Jason";
		String sn = "Derby";
		Customer customer = new Customer(fn, sn);
		Customer savedCustomer = new Customer(fn, sn);
		customer = customerDaoMysql.create(customer);
		assertEquals(savedCustomer, customer);
	}
	
	@Test
	public void updateTest() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(jdbcConnectionUrl, username, password);
		String fn = "Jason";
		String sn = "Derby";
		Long id = 1L;
		Customer customer = new Customer(id, sn, fn);
		Customer savedCustomer = new Customer(id, sn, fn);
		customer = customerDaoMysql.update(customer);
		assertEquals(savedCustomer, customer);
	}
	
	
}
