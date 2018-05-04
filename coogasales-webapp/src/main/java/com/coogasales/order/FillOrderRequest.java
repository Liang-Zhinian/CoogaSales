package com.coogasales.order;

import com.coogasales.Request;
import com.coogasales.SalesOrder;

public class FillOrderRequest extends Request {
	private String customerName;
	private String customerID;
	private SalesOrder salesOrder;
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	
	public SalesOrder getSalesOrder() {
		return salesOrder;
	}
	public void setSalesOrder(SalesOrder salesOrder) {
		this.salesOrder = salesOrder;
	}
}
