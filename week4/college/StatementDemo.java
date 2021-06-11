package com.main.java.week4.college;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.main.java.week4.db.DBConnection;
import com.main.java.week4.db.DBException;
import com.main.java.week4.model.Administrator;

/**
 * This class is used to perform JDBC 'Statement' operations to execute create,
 * update, insert, delete on database table
 * 
 * @since 2021-06-06
 * @version 1.1
 * @author Nikita Sheth
 *
 */

public class StatementDemo {
	static Logger logger = Logger.getLogger(StatementDemo.class.getName());

	/**
	 * This method is used to insert Administrator into database
	 * 
	 * @param admin
	 * @return Nothing
	 * @throws DBException
	 */
	public void addAdmin(Administrator admin) throws DBException {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			String query = "INSERT INTO Administrator(adminName,password) VALUES (\"" + admin.getAdminName() + "\",\""
					+ admin.getPassword() + "\")";
			stmt.execute(query);

			conn.commit();
			DBConnection.close(conn, stmt);
			// System.out.println("Data inserted in Administrator table");
			logger.info("Data inserted in Administrator table");
		} catch (SQLException | ClassNotFoundException e) {
			logger.debug(e.getMessage());
			// System.out.println(e.getMessage());
			DBConnection.close(conn, stmt);
			throw new DBException(e.getMessage());
		}
	}

	/**
	 * This method is used to delete Administrator from database
	 * 
	 * @param name
	 * @return Nothing
	 * @throws DBException
	 */
	public void deleteAdmin(String name) throws DBException {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			String query = "delete from Administrator where adminName=\"" + name + "\"";
			stmt.execute(query);

			conn.commit();
			DBConnection.close(conn, stmt);
			// System.out.println("Deleted row from Administrator table");
			logger.info("Deleted row from Administrator table");
		} catch (SQLException | ClassNotFoundException e) {
			logger.debug(e.getMessage());
			// System.out.println(e.getMessage());
			DBConnection.close(conn, stmt);
			throw new DBException(e.getMessage());
		}
	}

	/**
	 * This method is used to update Administrator table row
	 * 
	 * @param adminId
	 * @param admin
	 * @throws DBException
	 * @return Nothing
	 */

	public void updateAdmin(int adminId, Administrator admin) throws DBException {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			String query = "update Administrator set adminName =\"" + admin.getAdminName() + "\",password =\""
					+ admin.getPassword() + "\"where adminId = " + adminId;
			stmt.execute(query);
			conn.commit();
			DBConnection.close(conn, stmt);
			// System.out.println("Updated row from Administrator table");
			logger.info("Updated row from Administrator table");
		} catch (SQLException | ClassNotFoundException e) {
			logger.debug(e.getMessage());
			// System.out.println(e.getMessage());
			DBConnection.close(conn, stmt);
			throw new DBException(e.getMessage());
		}
	}

	/**
	 * This method is used to retrieve all Administrator from student table using
	 * select clause
	 * 
	 * @throws DBException
	 * @return Nothing
	 */
	public void getAllAdmin() throws DBException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet res = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			String query = "select * from Administrator";
			ResultSet rs = stmt.executeQuery(query);
			System.out.println("adminId		adminName 	password");

			while (rs.next()) {
				int adminId = rs.getInt("adminId");
				String name = rs.getString("adminName");
				String pass = rs.getString("password");
				System.out.println(adminId + "		" + name + "		" + pass);
				logger.info(adminId + "		" + name + "		" + pass);
			}
			conn.commit();
			DBConnection.close(conn, stmt, res);
		} catch (SQLException | ClassNotFoundException e) {
			logger.debug(e.getMessage());
			// System.out.println(e.getMessage());
			DBConnection.close(conn, stmt, res);
			throw new DBException(e.getMessage());
		}
	}

	/**
	 * This method is used to create table
	 * 
	 * @throws DBException
	 * @return Nothing
	 */
	public void createAdminTable() throws DBException {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			String query = "CREATE TABLE Administrator1 (AdminId int(11) NOT NULL AUTO_INCREMENT, AdminName varchar(20) NOT NULL,Password varchar(20) NOT NULL,PRIMARY KEY (AdminId))";
			stmt.execute(query);
			// System.out.println("Administrator1 table created");
			logger.info("Administrator1 table created");
			conn.commit();
			DBConnection.close(conn, stmt);
		} catch (SQLException | ClassNotFoundException e) {
			logger.debug(e.getMessage());
			// System.out.println(e.getMessage());
			DBConnection.close(conn, stmt);
			throw new DBException(e.getMessage());
		}
	}

	/**
	 * This is main method which drives
	 * createAdminTable(),addAdmin(Administrator),getAllAdmin(),updateAdmin(int,
	 * Administrator),deleteAdmin(String)
	 * 
	 * @param args
	 * @return Nothing
	 */
	public static void main(String[] args) {
		StatementDemo stmt = new StatementDemo();
		Administrator admin = new Administrator("admin3", "admin12");
		try {
			// stmt.createAdminTable();// call to create table

//			  System.out.println("After Update operation:");
//			  logger.info("After Update operation:"); 
//			  stmt.updateAdmin(4, admin);// update table method call 
//			  stmt.getAllAdmin();// call to get Admins

//			  System.out.println("After Delete operation: deleted admin3");
//			  logger.info("After Delete operation: deleted admin3");
//			  stmt.deleteAdmin("admin3");// call to delete operation stmt.getAllAdmin();
//			  stmt.getAllAdmin();// call to get Admins

			stmt.addAdmin(admin);// call to add administrator
			System.out.println("New row with name admin3 added...");
			logger.info("New row with name admin3 added...");

		} catch (DBException e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}

	}

}
