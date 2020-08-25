package com.customer.cusRecords;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerRecords {

	private double latitude;
	private double longitutde;
	private long user_id;
	private String customer_name;
	
	
	public CustomerRecords()
	{
	}

	
	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public double getLongitutde() {
		return longitutde;
	}


	public void setLongitutde(double longitutde) {
		this.longitutde = longitutde;
	}


	public long getUser_id() {
		return user_id;
	}


	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}


	public String getCustomer_name() {
		return customer_name;
	}


	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}


	@Override
	  public String toString() {
	    return "CustomerRecords [longitude=" + longitutde + ", latitude=" + latitude
	        + ", customer name=" + customer_name + "User ID=" + user_id +"]";
	  }
	
}
