package com.main.java.week4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Testjdbc {
	static final String DB_URL = "jdbc:mysql://localhost:3306/college";
	static final String USER = "root";
	static final String PASS = "root@123";

	public static Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
		return con;
	}

	public static void main(String[] args) {
		// Open a connection
		try {
			Statement stmt = getConnection().createStatement();
			System.out.println("Inserting records into the table...");
			String sql = "INSERT INTO student VALUES (2, 'Smith', '12345432')";
			stmt.executeUpdate(sql);
			System.out.println("Inserted records into the table...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}