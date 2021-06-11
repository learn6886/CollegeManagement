package com.main.java.week4.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

/**
 * This class provides database connections and related common operations
 * 
 * @since 2021-06-06
 * @version 1.1
 * @author Nikita Sheth
 *
 */
public class DBConnection {
	static Logger logger = Logger.getLogger(DBConnection.class.getName());
	Connection conn = null;

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/college";
	static final String USER = "root";
	static final String PASS = "root@123";

	/**
	 * Thid method is used to get connection
	 * 
	 * @return connection
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(JDBC_DRIVER);
		Connection connection = null;
		connection = DriverManager.getConnection(DB_URL, USER, PASS);
		logger.info("connected to db");
		return connection;

	}

	/**
	 * This method is to Commit and Close the connection
	 * 
	 * @param conn
	 * @throws SQLException
	 * @return nothing
	 */
	public static void commitAndClose(Connection conn) throws SQLException {
		conn.commit();
		conn.close();
	}

	/**
	 * This method is to close connection,prepared statement
	 * 
	 * @param con
	 * @param pstmt
	 * @return nothing
	 */
	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			logger.debug(e.getMessage());
			//System.out.println(e.getMessage());
		}
	}
	
	/**
	 * This method is to close connection, result set, prepared statement
	 * 
	 * @param con
	 * @param pstmt
	 * @param rs
	 * @return nothing
	 */
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			logger.debug(e.getMessage());
			//System.out.println(e.getMessage());
		}
	}
	
	/**
	 * This method is to close connection,statement
	 * 
	 * @param con
	 * @param stmt
	 * @return nothing
	 */
	public static void close(Connection conn, Statement stmt) {
		try {
			
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			logger.debug(e.getMessage());
			//System.out.println(e.getMessage());
		}
	}

	/**
	 * This method is to close connection, result set, statement
	 * 
	 * @param con
	 * @param stmt
	 * @param rs
	 * @return nothing
	 */
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			logger.debug(e.getMessage());
			//System.out.println(e.getMessage());
		}
	}

	/**
	 * This method is to close the connection
	 * 
	 * @param con
	 * @return nothing
	 */
	public static void closeConnection(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			logger.debug(e.getMessage());
			//System.out.println(e.getMessage());
		}
	}
}
