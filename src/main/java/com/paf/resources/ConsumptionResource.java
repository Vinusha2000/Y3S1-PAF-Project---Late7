package com.paf.resources;

import com.paf.model.*;
import com.paf.service.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;

@Path("/Consumptions")
public class ConsumptionResource {

	Consumption consumptionObj = new Consumption();

	// Read API
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readconsumptions() {
		ConsumptionService consumptionObj = new ConsumptionService();

		return consumptionObj.readconsumptions();
	}

	// Insert API
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertconsumption(String consumptionData) {
		JsonObject consumptionObject = new JsonParser().parse(consumptionData).getAsJsonObject();

		String RangeOfUnit = consumptionObject.get("RangeOfUnit").getAsString();
		Float Price = consumptionObject.get("Price").getAsFloat();
		String Date = consumptionObject.get("Date").getAsString();
		String Comments = consumptionObject.get("Comments").getAsString();

		ConsumptionService consumptionObject2 = new ConsumptionService();

		consumptionObj.setRangeOfUnit(RangeOfUnit);
		consumptionObj.setPrice(Price);
		consumptionObj.setDate(Date);
		consumptionObj.setComments(Comments);

		String output = consumptionObject2.insertconsumption(consumptionObj);
		return output;
	}

	// Update API
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateconsumption(String consumptionData) {
		// Convert the input string to a JSON object
		JsonObject consumptionObject = new JsonParser().parse(consumptionData).getAsJsonObject();
		// Read the values from the JSON object
		String RangeOfUnit = consumptionObject.get("RangeOfUnit").getAsString();
		Float Price = consumptionObject.get("Price").getAsFloat();
		String Date = consumptionObject.get("Date").getAsString();
		String Comments = consumptionObject.get("Comments").getAsString();

		ConsumptionService consumptionObject1 = new ConsumptionService();

		consumptionObj.setRangeOfUnit(RangeOfUnit);
		consumptionObj.setPrice(Price);
		consumptionObj.setDate(Date);
		consumptionObj.setComments(Comments);

		String output = consumptionObject1.updateconsumption(consumptionObj);
		return output;
	}

	// Delete API
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteconsumption(String consumptionData) {

		JsonObject consumptionObject = new JsonParser().parse(consumptionData).getAsJsonObject();

		String RangeOfUnit = consumptionObject.get("RangeOfUnit").getAsString();

		ConsumptionService consumptionObject2 = new ConsumptionService();
		consumptionObj.setRangeOfUnit(RangeOfUnit);

		String output = consumptionObject2.deleteconsumption(consumptionObj);
		return output;
	}

}