package com.paf.service;

import java.sql.*;
import com.paf.utils.DBConnection;
import com.paf.model.*;

public class PaymentService {
	Connection con = null;

	public PaymentService() {

		con = DBConnection.connecter();
	}

	// A common method to connect to the DB

	public String insertpayment(Payment payment) {
		String query = " insert into payment(`AccNumber`,`DateOfPayment`,`Amount`,`TypeOfPayment`)"
				+ " values (?,?, ?, ?)";

		String output;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, payment.getAccNumber());
			preparedStatement.setString(2, payment.getDateOfPayment());
			preparedStatement.setFloat(3, payment.getAmount());
			preparedStatement.setString(4, payment.getTypeOfPayment());

			preparedStatement.execute();
			con.close();
			output = "Inserted successfully";

		} catch (SQLException e) {
			output = "Error while inserting the payment.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	public String readpayments() {
		String output = "";
		try {

			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Account No</th><th>Date Of Payment</th><th>Amount</th><th>Payment Type</th></tr>";
			String query = "select * from payment";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String AccNumber = rs.getString("AccNumber");
				String DateOfPayment = rs.getString("DateOfPayment");
				String Amount = rs.getString("Amount");
				String TypeOfPayment = rs.getString("TypeOfPayment");

				// Add into the html table
				output += "<tr><td>" + AccNumber + "</td>";
				output += "<td>" + DateOfPayment + "</td>";
				output += "<td>" + Amount + "</td>";
				output += "<td>" + TypeOfPayment + "</td>";

			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the payments.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updatepayment(Payment payment) {

		String query = "UPDATE payment SET DateOfPayment=?,Amount=?,TypeOfPayment=? WHERE AccNumber=?";
		String output = "";
		try {

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			PreparedStatement preparedStatement = con.prepareStatement(query);

			preparedStatement.setString(1, payment.getDateOfPayment());
			preparedStatement.setFloat(2, payment.getAmount());
			preparedStatement.setString(3, payment.getTypeOfPayment());
			preparedStatement.setString(4, payment.getAccNumber());

			if (preparedStatement.executeUpdate() == 1) {
				output = "Updated successfully";
			} else {
				output = "Error while updating the Payment.";
			}

			con.close();

		} catch (Exception e) {
			output = "Error while updating the payment.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deletepayment(Payment payment) {
		String query = "delete from payment where AccNumber=?";
		String output;

		try {

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement

			PreparedStatement preparedStatement = con.prepareStatement(query);
			// binding values
			preparedStatement.setString(1, payment.getAccNumber());
			// execute the statement
			preparedStatement.execute();
			con.close();
			output = "Deleted successfully";
			//	 // execute the statement
			//	 if(preparedStatement.execute()) {
			//		 output = "Deleted successfully";
			//	 }else {
			//		 output = "id not found";
			//	 }
			//		
			//	 con.close();

		} catch (Exception e) {
			output = "Error while deleting the payment.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	public String asAccountNo(String AccNumber) {

		String output = "";

		try {

			if (con == null) {

				return "Error while connecting to the database for reading.";
			}
			output = "<table border=\"1\"><tr><th>Account No</th><th>User Id</th><th>Start Date</th><th>End Date</th><th>No Of Units</th><th> Amount</th></tr>";
			String query = "select * from billing where AccountNo = " + AccNumber;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
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
			output += "</table>";
		}catch (Exception e) {
			output = "Error while reading the items.";
			System.err.println(e.getMessage() + "---------------------------------------------");
		}
		return output;
	}

}
