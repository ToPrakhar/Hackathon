package com.infy.client;

import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.infy.entity.User;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class RESTClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Client c = Client.create();

		WebResource setUser = c
				.resource("http://localhost:8080/CarPool/service/insertUser");
		WebResource home = c
				.resource("http://localhost:8080/CarPool/service/home");
		
		setUserPassword(setUser);
		//welcomeService(home);

	}
	
	public static void setUserPassword(WebResource setUser) {
		Gson g = new Gson();
		User user = new User();
		user.setUserName("nmittal1");
		user.setPassword("nishant");
		String data = g.toJson(user);
		System.out.println("\nRequest : " + data);
		String response = setUser.accept(MediaType.WILDCARD).post(
				String.class, data);
		
		System.out.println("\nResponse : " + response);

	}

	public static void welcomeService(WebResource home) {

		String response = home.accept(MediaType.WILDCARD).get(String.class);
		System.out.println("\nResponse : " + response);

	}

}
