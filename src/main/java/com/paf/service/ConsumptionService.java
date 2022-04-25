package com.paf.service;

import java.sql.*;
import com.paf.utils.DBConnection;
import com.paf.model.*;

public class ConsumptionService {
	Connection con = null;

	public ConsumptionService() {

		con = DBConnection.connecter();
	}

	// A common method to connect to the DB

	public String insertconsumption(Consumption consumption) {
		String query = " insert into consumption(`RangeOfUnit`,`Price`,`Date`,`Comments`)" + " values (?,?, ?, ?)";

		String output;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, consumption.getRangeOfUnit());
			preparedStatement.setFloat(2, consumption.getPrice());
			preparedStatement.setString(3, consumption.getDate());
			preparedStatement.setString(4, consumption.getComments());

			preparedStatement.execute();
			con.close();
			output = "Inserted successfully";

		} catch (SQLException e) {
			output = "Error while inserting the consumption.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	public String readconsumptions() {
		String output = "";
		try {

			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Unit Range</th><th>Price</th><th>Date</th><th>Comments</th></tr>";
			String query = "select * from consumption";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String RangeOfUnit = rs.getString("RangeOfUnit");
				String Price = rs.getString("Price");
				String Date = rs.getString("Date");
				String Comments = rs.getString("Comments");

				// Add into the html table
				output += "<tr><td>" + RangeOfUnit + "</td>";
				output += "<td>" + Price + "</td>";
				output += "<td>" + Date + "</td>";
				output += "<td>" + Comments + "</td>";

			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the consumptions.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updateconsumption(Consumption consumption) {

		String query = "UPDATE consumption SET Price=?,Date=?,Comments=? WHERE RangeOfUnit=?";
		String output = "";
		try {

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			PreparedStatement preparedStatement = con.prepareStatement(query);

			preparedStatement.setFloat(1, consumption.getPrice());
			preparedStatement.setString(2, consumption.getDate());
			preparedStatement.setString(3, consumption.getComments());

			preparedStatement.setString(4, consumption.getRangeOfUnit());

			if (preparedStatement.executeUpdate() == 1) {
				output = "Updated successfully";
			} else {
				output = "Error while updating the Consumption.";
			}

			con.close();

		} catch (Exception e) {
			output = "Error while updating the consumption.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deleteconsumption(Consumption consumption) {
		String query = "delete from consumption where RangeOfUnit=?";
		String output;

		try {

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement

			PreparedStatement preparedStatement = con.prepareStatement(query);
			// binding values
			preparedStatement.setString(1, consumption.getRangeOfUnit());
			// execute the statement
			preparedStatement.execute();
			con.close();
			output = "Deleted successfully";

		} catch (Exception e) {
			output = "Error while deleting the consumption.";
			System.err.println(e.getMessage());
		}
		return output;
	}

}
