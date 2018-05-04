package com.coogasales.customer;

import com.coogasales.Customer;
import com.coogasales.Response;

public class GetCustomerResponse extends Response {
	private Boolean customerIDValid;
	private Customer customer;
	
	public Boolean getCustomerIDValid() {
		return customerIDValid;
	}
	public void setCustomerIDValid(Boolean customerIDValid) {
		this.customerIDValid = customerIDValid;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
