package com.paf.resources;

import com.paf.model.*;
import com.paf.service.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;

@Path("/Users")
public class UserResource {

	User userObj = new User();

	// Read API
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readusers() {
		UserService userObj = new UserService();

		return userObj.readusers();
	}

	// Insert API
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertuser(String userData) {
		JsonObject userObject = new JsonParser().parse(userData).getAsJsonObject();

		String Id = userObject.get("Id").getAsString();
		String Name = userObject.get("Name").getAsString();
		String Address = userObject.get("Address").getAsString();
		String PhoneNo = userObject.get("PhoneNo").getAsString();
		String Email = userObject.get("Email").getAsString();
		String AccountNo = userObject.get("AccountNo").getAsString();

		UserService userObject2 = new UserService();

		userObj.setId(Id);
		userObj.setName(Name);
		userObj.setAddress(Address);
		userObj.setPhoneNo(PhoneNo);
		userObj.setEmail(Email);
		userObj.setAccountNo(AccountNo);

		String output = userObject2.insertuser(userObj);
		return output;
	}

	// Update API
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateuser(String userData) {
		// Convert the input string to a JSON object
		JsonObject userObject = new JsonParser().parse(userData).getAsJsonObject();
		// Read the values from the JSON object
		String Id = userObject.get("Id").getAsString();
		String Name = userObject.get("Name").getAsString();
		String Address = userObject.get("Address").getAsString();
		String PhoneNo = userObject.get("PhoneNo").getAsString();
		String Email = userObject.get("Email").getAsString();
		String AccountNo = userObject.get("AccountNo").getAsString();

		UserService userObject1 = new UserService();

		userObj.setId(Id);
		userObj.setName(Name);
		userObj.setAddress(Address);
		userObj.setPhoneNo(PhoneNo);
		userObj.setEmail(Email);
		userObj.setAccountNo(AccountNo);

		String output = userObject1.updateuser(userObj);
		return output;
	}

	// Delete API
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteuser(String userData) {

		JsonObject userObject = new JsonParser().parse(userData).getAsJsonObject();

		String Id = userObject.get("Id").getAsString();

		UserService userObject2 = new UserService();
		userObj.setId(Id);

		String output = userObject2.deleteuser(userObj);
		return output;
	}

}