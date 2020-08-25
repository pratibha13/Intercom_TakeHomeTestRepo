package com.customer.cusRecords;

public class DisplayCustomerRecord {

	private long user_id;
	private String customer_name;
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
	    return "CustomerRecords [ customer name=" + customer_name + "User ID=" + user_id +"]";
	  }
}
