package com.coogasales.order;

import java.util.Date;
import java.util.List;

import com.coogasales.Address;
import com.coogasales.CreditCardInfo;
import com.coogasales.Request;

public class PlaceOrderRequest extends Request {
	private Date requestDate;
	private String customerID;
	private Address shippingAddress;
	private Address billingAddress;
	private CreditCardInfo paymentInfo;
	private List<SalesOrderRequestItem> salesItems;
	
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
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
	
	public CreditCardInfo getPaymentInfo() {
		return paymentInfo;
	}
	public void setPaymentInfo(CreditCardInfo paymentInfo) {
		this.paymentInfo = paymentInfo;
	}
	
	public List<SalesOrderRequestItem> getSalesItems() {
		return salesItems;
	}
	public void setSalesItems(List<SalesOrderRequestItem> salesItems) {
		this.salesItems = salesItems;
	}
}
