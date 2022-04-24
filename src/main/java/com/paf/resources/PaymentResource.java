package com.paf.resources;

import com.paf.model.*;
import com.paf.service.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;

@Path("/Payments")
public class PaymentResource {

	Payment paymentObj = new Payment();

	// Read API
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readpayments() {
		PaymentService paymentObj = new PaymentService();

		return paymentObj.readpayments();
	}

	// Insert API
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertpayment(String paymentData) {
		JsonObject paymentObject = new JsonParser().parse(paymentData).getAsJsonObject();

		String AccNumber = paymentObject.get("AccNumber").getAsString();
		String DateOfPayment = paymentObject.get("DateOfPayment").getAsString();
		Float Amount = paymentObject.get("Amount").getAsFloat();
		String TypeOfPayment = paymentObject.get("TypeOfPayment").getAsString();

		PaymentService paymentObject2 = new PaymentService();

		paymentObj.setAccNumber(AccNumber);
		paymentObj.setDateOfPayment(DateOfPayment);
		paymentObj.setAmount(Amount);
		paymentObj.setTypeOfPayment(TypeOfPayment);

		String output = paymentObject2.insertpayment(paymentObj);
		return output;
	}

	// Update API
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatepayment(String paymentData) {
		// Convert the input string to a JSON object
		JsonObject paymentObject = new JsonParser().parse(paymentData).getAsJsonObject();
		// Read the values from the JSON object
		String AccNumber = paymentObject.get("AccNumber").getAsString();
		String DateOfPayment = paymentObject.get("DateOfPayment").getAsString();
		Float Amount = paymentObject.get("Amount").getAsFloat();
		String TypeOfPayment = paymentObject.get("TypeOfPayment").getAsString();

		PaymentService paymentObject1 = new PaymentService();

		paymentObj.setAccNumber(AccNumber);
		paymentObj.setDateOfPayment(DateOfPayment);
		paymentObj.setAmount(Amount);
		paymentObj.setTypeOfPayment(TypeOfPayment);

		String output = paymentObject1.updatepayment(paymentObj);
		return output;
	}

	// Delete API
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletepayment(String paymentData) {

		JsonObject paymentObject = new JsonParser().parse(paymentData).getAsJsonObject();

		String AccNumber = paymentObject.get("AccNumber").getAsString();

		PaymentService paymentObject2 = new PaymentService();
		paymentObj.setAccNumber(AccNumber);

		String output = paymentObject2.deletepayment(paymentObj);
		return output;
	}
	@GET
	@Path("/AccountInfo/{AccNumber}")
	@Produces(MediaType.APPLICATION_JSON)
	public String readPaymentAccordingToAccountNo(@PathParam("AccNumber") String AccNumber) {
		PaymentService payObj = new PaymentService();
		return payObj.asAccountNo(AccNumber);
	}

}