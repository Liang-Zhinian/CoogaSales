package com.coogasales;

import java.util.Date;
import java.util.List;

import com.coogasales.order.SalesOrderRequestItem;

public class SalesOrder {

	private Date datePlaced;
	private String orderID;
	private String status;
	private Address shippingAddress;
	private Address billingAddress;
	private List<SalesOrderLineItem> lineItems;
	
	public Date getDatePlaced() {
		return datePlaced;
	}
	public void setDatePlaced(Date datePlaced) {
		this.datePlaced = datePlaced;
	}
	
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Address getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
	public Address getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
	
	public List<SalesOrderLineItem> getLineItems() {
		return lineItems;
	}
	public void setLineItems(List<SalesOrderLineItem> lineItems) {
		this.lineItems = lineItems;
	}
}
