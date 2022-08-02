package com.wallet.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;


public class DaoUtility {

	static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/faisal?" + "user=root&password=FAISALkhan@123");
			System.out.println("Successful Connection to Mysql ");
			
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());

		}
		
		return connection;

	}
}