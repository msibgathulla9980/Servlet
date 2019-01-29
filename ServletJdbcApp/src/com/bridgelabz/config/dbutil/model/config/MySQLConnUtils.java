package com.bridgelabz.config.dbutil.model.config;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.bridgelabz.config.dbutil.model.details.RegistrationDetails;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class MySQLConnUtils {

	public static Connection getMySQLConnection() throws ClassNotFoundException, SQLException {
		String hostName="localhost";
		String dbName="Servletjdbc";
		String userName = "root";
		String password = "password";
				return getMySQLConnection(hostName, dbName, userName, password);
	}
	public static Connection getMySQLConnection(String hostName, String dbName,String userName, String password) throws SQLException,
	         ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String connectionURL="jdbc:mysql://" +hostName+":3306/" +dbName;
		Connection conn=(Connection) DriverManager.getConnection(connectionURL, userName, password);
		return conn;
		
	}
	
	public static void Registration(RegistrationDetails user) throws ClassNotFoundException, SQLException {
		String query="insert into User (UserID, firstName, lastName, Email, PhoneNumber, password) VALUES(?,?,?,?,?,?)";
		Connection conn=getMySQLConnection();
		PreparedStatement preparedstmt=(PreparedStatement) conn.prepareStatement(query);
		preparedstmt.setInt(1, 0);
		preparedstmt.setString(2,user.getFirstName());
		preparedstmt.setString(3,user.getLastName());
		preparedstmt.setString(4,user.getEmail());
		preparedstmt.setString(5,user.getPhoneNumber());
		preparedstmt.setString(6,user.getPassword());
		preparedstmt.execute();
		conn.close();
		
	}
	public static RegistrationDetails Registration1(RegistrationDetails userlogin) throws ClassNotFoundException, SQLException {
		String query="select * from User where email=? and password=?";
		Connection conn=getMySQLConnection();
		RegistrationDetails logcheck=null;
		PreparedStatement preparedstmt=(PreparedStatement) conn.prepareStatement(query);
		preparedstmt.setString(1,userlogin.getEmail());
		preparedstmt.setString(2,userlogin.getPassword());
		ResultSet res= preparedstmt.executeQuery();
		while(res.next()) {
			logcheck=new RegistrationDetails();
		}
		conn.close();
		preparedstmt.close();
		return logcheck;
	}
	}
	   