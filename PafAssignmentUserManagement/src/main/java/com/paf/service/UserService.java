package com.paf.service;

import java.sql.*;
import com.paf.utils.DBConnection;
import com.paf.model.*;

public class UserService {
	Connection con = null;

	public UserService() {

		con = DBConnection.connecter();
	}

	// A common method to connect to the DB

	public String insertuser(User user) {
		String query = " insert into user(`Id`,`Name`,`Address`,`PhoneNo`,`Email`,`AccountNo`)"
				+ " values (?,?, ?, ?, ?, ?)";

		String output;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, user.getId());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getAddress());
			preparedStatement.setString(4, user.getPhoneNo());
			preparedStatement.setString(5, user.getEmail());
			preparedStatement.setString(6, user.getAccountNo());
			preparedStatement.execute();
			con.close();
			output = "Inserted successfully";

		} catch (SQLException e) {
			output = "Error while inserting the user.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	public String readusers() {
		String output = "";
		try {

			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>User Id</th><th>User Name</th><th>Address</th><th>Mobile</th><th>Email</th><th>Account Number</th></tr>";
			String query = "select * from user";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String Id = rs.getString("Id");
				String Name = rs.getString("Name");
				String Address = rs.getString("Address");
				String PhoneNo = rs.getString("PhoneNo");
				String Email = rs.getString("Email");
				String AccountNo = rs.getString("AccountNo");
				// Add into the html table
				output += "<tr><td>" + Id + "</td>";
				output += "<td>" + Name + "</td>";
				output += "<td>" + Address + "</td>";
				output += "<td>" + PhoneNo + "</td>";
				output += "<td>" + Email + "</td>";
				output += "<td>" + AccountNo + "</td>";

			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the users.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updateuser(User user) {

		String query = "UPDATE user SET Name=?,Address=?,PhoneNo=?,Email=?,AccountNo=? WHERE Id=?";
		String output = "";
		try {

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			PreparedStatement preparedStatement = con.prepareStatement(query);

			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getAddress());
			preparedStatement.setString(3, user.getPhoneNo());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getAccountNo());
			preparedStatement.setString(6, user.getId());

			if (preparedStatement.executeUpdate() == 1) {
				output = "Updated successfully";
			} else {
				output = "Error while updating the Billing.";
			}

			con.close();

		} catch (Exception e) {
			output = "Error while updating the user.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deleteuser(User user) {
		String query = "delete from user where Id=?";
		String output;

		try {

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement

			PreparedStatement preparedStatement = con.prepareStatement(query);
			// binding values
			preparedStatement.setString(1, user.getId());
			// execute the statement
			preparedStatement.execute();
			con.close();
			output = "Deleted successfully";

		} catch (Exception e) {
			output = "Error while deleting the user.";
			System.err.println(e.getMessage());
		}
		return output;
	}

}
