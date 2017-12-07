package com.cmd.db;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.cmd.global.Variables;

import java.sql.Connection;

public class MysqlConnection {
	
	private Connection connection = null;
	
	
	public MysqlConnection() {
		System.out.println("------------ MySQL JDBC Connection Testing ------------");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Please check you JDBC Driver !!!!");
			e.printStackTrace();
			return;
		}
		
		System.out.println("MySQL JDBC Driver Registered!");
		
		try {
			connection = DriverManager
							.getConnection("jdbc:mysql://localhost" + Variables.dataBasePort + 
							"/" + Variables.dataBaseName + "?useSSL=false",
							Variables.dataBaseUsername, Variables.dataBasePassword);

		} catch (SQLException e) {
			System.err.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
		
		if (connection != null) {
			System.out.println("DB Connection is Fine !!");
		} else {
			System.err.println("DB Connection Failed !!");
		}
	}
}
