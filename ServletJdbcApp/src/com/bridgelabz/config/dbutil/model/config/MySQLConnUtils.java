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
		String query="insert into User (UserID, firstName, lastName, Email, PhoneNumber, password, gender) VALUES(?,?,?,?,?,?,?)";
		Connection conn=getMySQLConnection();
		PreparedStatement preparedstmt=(PreparedStatement) conn.prepareStatement(query);
		preparedstmt.setInt(1, 0);
		preparedstmt.setString(2,user.getFirstName());
		preparedstmt.setString(3,user.getLastName());
		preparedstmt.setString(4,user.getEmail());
		preparedstmt.setString(5,user.getPhoneNumber());
		preparedstmt.setString(6,user.getPassword());
		preparedstmt.setString(7,user.getGender());
		preparedstmt.execute();
		conn.close();
		preparedstmt.close();
		
	}
	public static RegistrationDetails Validation (RegistrationDetails userlogin) throws ClassNotFoundException, SQLException {
		String query="select * from User where email=? and password=?";
		Connection conn=getMySQLConnection();
		RegistrationDetails logcheck=null;
		PreparedStatement preparedstmt=(PreparedStatement) conn.prepareStatement(query);
		preparedstmt.setString(1,userlogin.getEmail());
		preparedstmt.setString(2,userlogin.getPassword());
		ResultSet res= preparedstmt.executeQuery();
		while(res.next()) {
			logcheck=new RegistrationDetails();
			logcheck.setFirstName(res.getString(2));
			logcheck.setLastName(res.getString(3));
			logcheck.setEmail(res.getString(4));
			logcheck.setPassword(res.getString(5));
			logcheck.setPhoneNumber(res.getString(6));
			logcheck.setGender(res.getString(7));
			
		}
		conn.close();
		preparedstmt.close();
		return logcheck;
	}
	public static void edit(RegistrationDetails user) throws ClassNotFoundException, SQLException {
		String dbupdate="update User set firstName=?,lastName=?,PhoneNumber=?, password=?, gender=? where Email=?";
	Connection conn=MySQLConnUtils.getMySQLConnection();
	PreparedStatement update=(PreparedStatement) conn.prepareStatement(dbupdate);
		update.setString(1, user.getFirstName());
		update.setString(2, user.getLastName());
		update.setString(3, user.getPhoneNumber());
		update.setString(4, user.getPassword());
		update.setString(5, user.getEmail());
		update.setString(6, user.getGender());
		
		update.executeUpdate();
	update.close();
	conn.close();
	}
	}
	   