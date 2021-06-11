package com.main.java.week4.college;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.main.java.week4.db.DBConnection;
import com.main.java.week4.db.DBException;
import com.main.java.week4.model.Student;

/**
 * This class is used to perform JDBC 'PreparedStatement' operations to execute
 * create, update, insert, delete on database tables
 * 
 * @since 2021-06-06
 * @version 1.1
 * @author Nikita Sheth
 *
 */

public class PrepareStatementDemo {
	static Logger logger = Logger.getLogger(PrepareStatementDemo.class.getName());

	/**
	 * This method is used to insert student into database
	 * 
	 * @param stud
	 * @return
	 * @throws DBException
	 */
	public int addStudent(Student stud) throws DBException {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		ResultSet res = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement("INSERT INTO Student(SName,ContactNo,Address) VALUES (?,?,?)");
			ps.setString(1, stud.getstudName());
			ps.setString(2, stud.getStudContact());
			ps.setString(3, stud.getAddress());
			result = ps.executeUpdate();

			// System.out.println("Data inserted in student table");
			logger.info("Data inserted in student table");
			conn.commit();
			DBConnection.close(conn, ps, res);
		} catch (SQLException | ClassNotFoundException e) {
			logger.debug(e.getMessage());
			// System.out.println(e.getMessage());
			DBConnection.close(conn, ps, res);
			throw new DBException(e.getMessage());
		}
		return result;
	}

	/**
	 * This method is used to delete student from database
	 * 
	 * @param stud
	 * @return
	 * @throws DBException
	 */
	public void deleteStudent(String name) throws DBException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement("delete from Student where SName=?");
			ps.setString(1, name);
			ps.executeUpdate();

			conn.commit();
			DBConnection.close(conn, ps);
			// System.out.println("Data deleted from student table");
			logger.info("Data deleted from student table");
		} catch (SQLException | ClassNotFoundException e) {
			logger.debug(e.getMessage());
			// System.out.println(e.getMessage());
			DBConnection.close(conn, ps);
			throw new DBException(e.getMessage());
		}
	}

	/**
	 * This method is used to update student table row
	 * 
	 * @param rollNo
	 * @param stud
	 * @throws DBException
	 * @return Nothing
	 */
	public void updateStudent(int rollNo, Student stud) throws DBException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement("update Student set SName = ?,ContactNo = ?,Address=? where RollNo = ?");
			ps.setString(1, stud.getstudName());
			ps.setString(2, stud.getStudContact());
			ps.setString(3, stud.getAddress());
			ps.setInt(4, rollNo);
			ps.executeUpdate();

			conn.commit();
			DBConnection.close(conn, ps);
			// System.out.println("Updated student table row");
			logger.info("Updated student table row");
		} catch (SQLException | ClassNotFoundException e) {
			// logger.debug(e.getMessage());
			System.out.println(e.getMessage());
			DBConnection.close(conn, ps);
			throw new DBException(e.getMessage());
		}
	}

	/**
	 * This method is used to retrieve all students from student table using select
	 * clause
	 * 
	 * @throws DBException
	 * @return Nothing
	 */
	public void getAllStudents() throws DBException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement("select * from Student");
			ResultSet rs = ps.executeQuery();
			System.out.println("RollNo		StudName 	StudContact");

			while (rs.next()) {
				int rollNo = rs.getInt("RollNo");
				String name = rs.getString("SName");
				String contact = rs.getString("ContactNo");
				System.out.println(rollNo + "		" + name + "		" + contact);
				logger.info(rollNo + "		" + name + "		" + contact);
			}

			conn.commit();
			DBConnection.close(conn, ps, res);
		} catch (SQLException | ClassNotFoundException e) {
			logger.debug(e.getMessage());
			// System.out.println(e.getMessage());
			DBConnection.close(conn, ps, res);
			throw new DBException(e.getMessage());
		}
	}

	/**
	 * This method is used to create table
	 * 
	 * @throws DBException
	 * @return Nothing
	 */
	public void createStudentTable() throws DBException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(
					"CREATE TABLE Student1 (RollNo int(11) NOT NULL, SName varchar(20) NOT NULL,ContactNo varchar(20) NOT NULL,PRIMARY KEY (RollNo))");
			ps.execute();
			// System.out.println("Student1 table created");
			logger.info("Student1 table created");
			conn.commit();
			DBConnection.close(conn, ps);
		} catch (SQLException | ClassNotFoundException e) {
			logger.debug(e.getMessage());
			// System.out.println(e.getMessage());
			DBConnection.close(conn, ps);
			throw new DBException(e.getMessage());
		}
	}

	/**
	 * This is main method which drives
	 * createStudentTable(),addStudent(Student),getAllStudents(),updateStudent(int,
	 * Student)
	 * 
	 * @param args
	 * @return Nothing
	 */
	public static void main(String[] args) {
		PrepareStatementDemo pstmt = new PrepareStatementDemo();
		Student stud = new Student("Linda K", "1234567890", "Pune");
		try {
			// pstmt.createStudentTable();// call to create table

			/*
			 * System.out.println("After Update operation:");
			 * logger.info("After Update operation:"); pstmt.updateStudent(4, stud);
			 * pstmt.getAllStudents();// call to get students
			 */

			/*
			 * System.out.println("After Delete operation: deleted Linda K");
			 * logger.info("After Delete operation: deleted Linda K");
			 * pstmt.deleteStudent("Linda K");//call to delete operation
			 * pstmt.getAllStudents();
			 */

			// call to add student
			int result = pstmt.addStudent(stud);
			if (0 != result) {
				System.out.println("New Student Linda K added...");
				logger.info("New Student Linda K added...");
			}

		} catch (DBException e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}

	}

}
