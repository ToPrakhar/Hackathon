package com.infy.client;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.infy.entity.Add;
import com.infy.entity.User;
import com.infy.entity.VehicleDetails;
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
		WebResource setVehicleDetails = c
				.resource("http://localhost:8080/CarPool/service/insertVehicleDetails");
		WebResource setAdd = c
				.resource("http://localhost:8080/CarPool/service/insertAdd");
		WebResource home = c
				.resource("http://localhost:8080/CarPool/service/home");
		
		//setUserPassword(setUser);
		//welcomeService(home);
		//setVehicleDetails(setVehicleDetails);
		setAdd(setAdd);

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
	
	public static void setVehicleDetails(WebResource setVehicleDetails) {
		Gson g = new Gson();
		List<VehicleDetails> list = new ArrayList<VehicleDetails>();
		VehicleDetails vehicleDetails1 = new VehicleDetails();
		vehicleDetails1.setOwner("nmittal1");
		vehicleDetails1.setCarNumber("DL 80-ABCD-8989");
		vehicleDetails1.setCarColor("red");
		vehicleDetails1.setCarModel("Honda");
		list.add(vehicleDetails1);
		
		
		VehicleDetails vehicleDetails2 = new VehicleDetails();
		vehicleDetails2.setOwner("nmittal1");
		vehicleDetails2.setCarNumber("DL 80-zyxa-9889");
		vehicleDetails2.setCarColor("Black");
		vehicleDetails2.setCarModel("Toyota");
		list.add(vehicleDetails2);
		
		
		String data = g.toJson(list);
		System.out.println("\nRequest : " + data);
		String response = setVehicleDetails.accept(MediaType.WILDCARD).post(
				String.class, data);
		
		System.out.println("\nResponse : " + response);

	}
	
	public static void setAdd(WebResource setAdd) {
		Gson g = new Gson();
		Add add = new Add();
		List<String> listVia = new ArrayList<String>();
		
		add.setOwner("nmittal1");
		add.setDate("20-02-2015");
		add.setDestination("Garnet");
		add.setStartLocation("Sandy Springs");
		add.setTripCost("20");
		listVia.add("Five Points");
		listVia.add("BuckHead");
		
		add.setVia(listVia);
		String data = g.toJson(add);
		
		System.out.println("\nRequest : " + data);
		String response = setAdd.accept(MediaType.WILDCARD).post(
				String.class, data);
		
		System.out.println("\nResponse : " + response);
	}

	public static void welcomeService(WebResource home) {

		String response = home.accept(MediaType.WILDCARD).get(String.class);
		System.out.println("\nResponse : " + response);

	}

}
