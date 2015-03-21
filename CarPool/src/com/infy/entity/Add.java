package com.infy.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Add {

	private String date;
	private String tripCost;
	private String startLocation;
	private String destination;
	private List<String> via;
	private String owner;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTripCost() {
		return tripCost;
	}
	public void setTripCost(String tripCost) {
		this.tripCost = tripCost;
	}
	public String getStartLocation() {
		return startLocation;
	}
	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public List<String> getVia() {
		return via;
	}
	public void setVia(List<String> via) {
		this.via = via;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
}
