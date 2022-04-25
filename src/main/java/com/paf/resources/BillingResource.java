package com.paf.resources;

import com.paf.model.*;
import com.paf.service.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;

@Path("/Billings")
public class BillingResource {

	Billing billingObj = new Billing();

	// Read API
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readbillings() {
		BillingService billingObj = new BillingService();

		return billingObj.readbillings();
	}

	// Insert API
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertbilling(String billingData) {
		JsonObject billingObject = new JsonParser().parse(billingData).getAsJsonObject();

		String AccountNo = billingObject.get("AccountNo").getAsString();
		String UserId = billingObject.get("UserId").getAsString();
		String BillingStartDate = billingObject.get("BillingStartDate").getAsString();
		String BillingEndDate = billingObject.get("BillingEndDate").getAsString();
		Float NoOfUnits = billingObject.get("NoOfUnits").getAsFloat();
		

		BillingService billingObject2 = new BillingService();

		billingObj.setAccountNo(AccountNo);
		billingObj.setUserId(UserId);
		billingObj.setBillingStartDate(BillingStartDate);
		billingObj.setBillingEndDate(BillingEndDate);
		billingObj.setNoOfUnits(NoOfUnits);
		

		String output = billingObject2.insertbilling(billingObj);
		return output;
	}

	// Update API
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatebilling(String billingData) {
		// Convert the input string to a JSON object
		JsonObject billingObject = new JsonParser().parse(billingData).getAsJsonObject();
		// Read the values from the JSON object
		String AccountNo = billingObject.get("AccountNo").getAsString();
		String UserId = billingObject.get("UserId").getAsString();
		String BillingStartDate = billingObject.get("BillingStartDate").getAsString();
		String BillingEndDate = billingObject.get("BillingEndDate").getAsString();
		Float NoOfUnits = billingObject.get("NoOfUnits").getAsFloat();
		

		BillingService billingObject1 = new BillingService();

		billingObj.setAccountNo(AccountNo);
		billingObj.setUserId(UserId);
		billingObj.setBillingStartDate(BillingStartDate);
		billingObj.setBillingEndDate(BillingEndDate);
		billingObj.setNoOfUnits(NoOfUnits);
		

		String output = billingObject1.updatebilling(billingObj);
		return output;
	}

	// Delete API
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletebilling(String billingData) {

		JsonObject billingObject = new JsonParser().parse(billingData).getAsJsonObject();

		String AccountNo = billingObject.get("AccountNo").getAsString();

		BillingService billingObject2 = new BillingService();
		billingObj.setAccountNo(AccountNo);

		String output = billingObject2.deletebilling(billingObj);
		return output;
	}
}