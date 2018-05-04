package com.coogasales.credit;

import com.coogasales.Response;

public class ObtainPaymentResponse extends Response {
	private Boolean paymentObtained;
	private double paymentAmount;
	private String transactionID;
	
	public Boolean getPaymentObtained() {
		return paymentObtained;
	}
	public void setPaymentObtained(Boolean paymentObtained) {
		this.paymentObtained = paymentObtained;
	}
	
	public double getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	
	public String getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}
}
