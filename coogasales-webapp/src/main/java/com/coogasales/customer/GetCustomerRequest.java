package com.coogasales.customer;

import com.coogasales.Request;

public class GetCustomerRequest extends Request {
	private String customerID;
	
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
}
