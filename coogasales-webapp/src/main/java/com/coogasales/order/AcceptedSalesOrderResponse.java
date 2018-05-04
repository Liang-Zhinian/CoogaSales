package com.coogasales.order;

public class AcceptedSalesOrderResponse extends PlaceOrderResponse {
	private String orderID;

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
}
