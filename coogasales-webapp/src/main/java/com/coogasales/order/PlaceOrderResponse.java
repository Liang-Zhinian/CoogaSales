package com.coogasales.order;

import com.coogasales.Response;

public abstract class PlaceOrderResponse extends Response {
	private Boolean orderAccepted;

	public Boolean getOrderAccepted() {
		return orderAccepted;
	}

	public void setOrderAccepted(Boolean orderAccepted) {
		this.orderAccepted = orderAccepted;
	}
}
