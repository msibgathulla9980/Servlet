package com.bridgelabz.config.dbutil.model.config;

import java.sql.SQLException;
import com.bridgelabz.config.dbutil.model.details.RegistrationDetails;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class UserUpdate {

	public static void edit(RegistrationDetails user) throws ClassNotFoundException, SQLException {
		String dbupdate="update USERINFORMATION set firstName=?,lastName=?,PhoneNumber=?, password=? where Email=?";
	Connection conn=MySQLConnUtils.getMySQLConnection();
	PreparedStatement update=(PreparedStatement) conn.prepareStatement(dbupdate);
		update.setString(2, user.getFirstName());
		update.setString(3, user.getLastName());
		update.setString(4, user.getEmail());
		update.setString(5, user.getPassword());
		update.setString(6, user.getPhoneNumber());
		update.executeUpdate();
	update.close();
	conn.close();
	}
	
}
