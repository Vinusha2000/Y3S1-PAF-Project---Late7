package com.paf.service;

import java.sql.*;
import com.paf.utils.DBConnection;
import com.paf.model.*;

public class BillingService {
	Connection con = null;

	public BillingService() {

		con = DBConnection.connecter();
	}

	// A common method to connect to the DB

	public String insertbilling(Billing billing) {
		String query = " insert into billing(`AccountNo`,`UserId`,`BillingStartDate`,`BillingEndDate`,`NoOfUnits`, ArrearsAmount)"
				+ " values (?,?, ?, ?, ?, ?)";
		float Amount = 0;
		try {

			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			float intNoOfUnits = billing.getNoOfUnits();
			String querySelect = "select * from consumption";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(querySelect);
			float priceG1 = 0;
			float priceG2 = 0;
			float priceG3 = 0;
			float priceG4 = 0;
			float priceG5 = 0;
			 
			while (rs.next()) {
				String RangeOfUnit = rs.getString("RangeOfUnit");
				if(RangeOfUnit.equals("1-25")) {
					priceG1 = rs.getFloat("Price");
				}
				else if(RangeOfUnit.equals("26-50")) {
					priceG2 = rs.getFloat("Price");
				}
				else if(RangeOfUnit.equals("51-75")) {
					priceG3 = rs.getFloat("Price");
				}
				else if(RangeOfUnit.equals("76-100")) {
					priceG4 = rs.getFloat("Price");
				}
				else {
					priceG5 = rs.getFloat("Price");
				}
			}
			
			if(intNoOfUnits > 100) {
				Amount = 25 * priceG1 + 25 * priceG2 + 25 * priceG3 + 25 * priceG4 + (intNoOfUnits - 100) * priceG5;
			}
			else if(intNoOfUnits > 75 && intNoOfUnits < 101) {
				Amount = 25 * priceG1 + 25 * priceG2 + 25 * priceG3 + (intNoOfUnits - 75) * priceG4;
			}
			else if(intNoOfUnits > 50 && intNoOfUnits < 76) {
				Amount = 25 * priceG1 + 25 * priceG2 + (intNoOfUnits - 50)  * priceG3;
			}
			else if(intNoOfUnits > 25 && intNoOfUnits < 51) {
				Amount = 25 * priceG1 + (intNoOfUnits - 25)  * priceG2;
			}
			else {
				Amount = intNoOfUnits * priceG1;
			}
			
		} catch (Exception e) {
			
			System.err.println(e.getMessage() + "---------------------------------------------");
		}
		String output;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, billing.getAccountNo());
			preparedStatement.setString(2, billing.getUserId());
			preparedStatement.setString(3, billing.getBillingStartDate());
			preparedStatement.setString(4, billing.getBillingEndDate());
			preparedStatement.setFloat(5, billing.getNoOfUnits());
			preparedStatement.setFloat(6, Amount);
			preparedStatement.execute();
			con.close();
			output = "Inserted successfully";

		} catch (SQLException e) {
			output = "Error while inserting the billing.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	public String readbillings() {
		String output = "";
		try {

			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Account No</th><th>User Id</th><th>Start Date</th><th>End Date</th><th>No Of Units</th><th>Amount</th></tr>";
			String query = "select * from billing";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String AccountNo = rs.getString("AccountNo");
				String UserId = rs.getString("UserId");
				String BillingStartDate = rs.getString("BillingStartDate");
				String BillingEndDate = rs.getString("BillingEndDate");
				String NoOfUnits = rs.getString("NoOfUnits");
				String ArrearsAmount = Double.toString(rs.getDouble("ArrearsAmount"));
				// Add into the html table
				output += "<tr><td>" + AccountNo + "</td>";
				output += "<td>" + UserId + "</td>";
				output += "<td>" + BillingStartDate + "</td>";
				output += "<td>" + BillingEndDate + "</td>";
				output += "<td>" + NoOfUnits + "</td>";
				output += "<td>" + ArrearsAmount + "</td>";

			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the billings.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updatebilling(Billing billing) {

		String query = "UPDATE billing SET UserId=?,BillingStartDate=?,BillingEndDate=?,NoOfUnits=?,ArrearsAmount=? WHERE AccountNo=?";
		String output = "";
		float Amount = 0;
		try {

			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			float intNoOfUnits = billing.getNoOfUnits();
			String querySelect = "select * from consumption";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(querySelect);
			float priceG1 = 0;
			float priceG2 = 0;
			float priceG3 = 0;
			float priceG4 = 0;
			float priceG5 = 0;
			 
			while (rs.next()) {
				String RangeOfUnit = rs.getString("RangeOfUnit");
				if(RangeOfUnit.equals("1-25")) {
					priceG1 = rs.getFloat("Price");
				}
				else if(RangeOfUnit.equals("26-50")) {
					priceG2 = rs.getFloat("Price");
				}
				else if(RangeOfUnit.equals("51-75")) {
					priceG3 = rs.getFloat("Price");
				}
				else if(RangeOfUnit.equals("76-100")) {
					priceG4 = rs.getFloat("Price");
				}
				else {
					priceG5 = rs.getFloat("Price");
				}
			}
			
			if(intNoOfUnits > 100) {
				Amount = 25 * priceG1 + 25 * priceG2 + 25 * priceG3 + 25 * priceG4 + (intNoOfUnits - 100) * priceG5;
			}
			else if(intNoOfUnits > 75 && intNoOfUnits < 101) {
				Amount = 25 * priceG1 + 25 * priceG2 + 25 * priceG3 + (intNoOfUnits - 75) * priceG4;
			}
			else if(intNoOfUnits > 50 && intNoOfUnits < 76) {
				Amount = 25 * priceG1 + 25 * priceG2 + (intNoOfUnits - 50)  * priceG3;
			}
			else if(intNoOfUnits > 25 && intNoOfUnits < 51) {
				Amount = 25 * priceG1 + (intNoOfUnits - 25)  * priceG2;
			}
			else {
				Amount = intNoOfUnits * priceG1;
			}
			
		} catch (Exception e) {
			
			System.err.println(e.getMessage() + "---------------------------------------------");
		}
		try {

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			PreparedStatement preparedStatement = con.prepareStatement(query);

			preparedStatement.setString(1, billing.getUserId());
			preparedStatement.setString(2, billing.getBillingStartDate());
			preparedStatement.setString(3, billing.getBillingEndDate());
			preparedStatement.setFloat(4, billing.getNoOfUnits());
			preparedStatement.setFloat(5, Amount);
			preparedStatement.setString(6, billing.getAccountNo());

			if (preparedStatement.executeUpdate() == 1) {
				output = "Updated successfully";
			} else {
				output = "Error while updating the billing.";
			}

			con.close();

		} catch (

		Exception e) {
			output = "Error while updating the billing.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deletebilling(Billing billing) {
		String query = "delete from billing where AccountNo=?";
		String output;

		try {

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement

			PreparedStatement preparedStatement = con.prepareStatement(query);
			// binding values
			preparedStatement.setString(1, billing.getAccountNo());
			// execute the statement
			preparedStatement.execute();
			con.close();
			output = "Deleted successfully";

		} catch (Exception e) {
			output = "Error while deleting the billing.";
			System.err.println(e.getMessage());
		}
		return output;
	}
}
