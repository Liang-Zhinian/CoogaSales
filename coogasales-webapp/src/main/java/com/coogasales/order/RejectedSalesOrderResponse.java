package com.coogasales.order;

public class RejectedSalesOrderResponse extends PlaceOrderResponse {
	private String rejectionReason;

	public String getRejectionReason() {
		return rejectionReason;
	}

	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
	}
}
