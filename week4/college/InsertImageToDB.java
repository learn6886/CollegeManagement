package com.main.java.week4.college;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.main.java.week4.db.DBConnection;
import com.main.java.week4.db.DBException;

/**
 * This class is used to insert and retrieve image from mysql table in form of (blob)
 * 
 * @since 2021-06-06
 * @version 1.1
 * @author Nikita Sheth
 */
public class InsertImageToDB {
	static Logger logger = Logger.getLogger(InsertImageToDB.class.getName());
	/**
	 * This method is used to insert image in table
	 * 
	 * @throws DBException
	 * @return Nothing
	 * @throws FileNotFoundException
	 */

	public static void insertImage() throws DBException, FileNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement("INSERT INTO image(image) VALUES(?)");
			InputStream in = new FileInputStream("C:\\Users\\Nikita Sheth\\Desktop\\Globant\\1.jpg");
			ps.setBlob(1, in);
			ps.executeUpdate();
			System.out.println("Image inserted to image table");
			logger.info("Image inserted to image table");
			conn.commit();
			DBConnection.close(conn, ps);
		} catch (SQLException | ClassNotFoundException e) {
		    logger.debug(e.getMessage());
			//System.out.println(e.getMessage());
			DBConnection.close(conn, ps);
			throw new DBException(e.getMessage());
		}
	}
	/**
	 * This method is used to retrieve image from database 
	 * @throws DBException
	 * @throws IOException 
	 */
	public static void getImage() throws DBException, IOException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement("select * from image");
			ResultSet rs=ps.executeQuery();  
			if(rs.next()){//1st row  
			Blob b=rs.getBlob(2);//read 2nd column   
			byte[] bytearr=b.getBytes(1,(int)b.length());//1 means first image  
			FileOutputStream fout=new FileOutputStream("C:\\Users\\Nikita Sheth\\Desktop\\Globant\\copy.jpg");  
			fout.write(bytearr);  
			fout.close();  
			}//end if
			System.out.println("Retrieve Image from table");
			logger.info("Retrieve Image from table");
			conn.commit();
			DBConnection.close(conn, ps);
		} catch (SQLException | ClassNotFoundException e) {
			logger.debug(e.getMessage());
			//System.out.println(e.getMessage());
			DBConnection.close(conn, ps);
			throw new DBException(e.getMessage());
		}
	}
/**
 * This method drives insertImage(),getImage()
 * @param args
 */
	public static void main(String[] args) {
		try {
			//insertImage();//call to insert image method
			getImage(); //call to get image method
		} catch (IOException | DBException e) {
			e.printStackTrace();
			//System.out.println("Error "+e.getMessage());
			logger.debug(e.getMessage());
		}
	}

}
