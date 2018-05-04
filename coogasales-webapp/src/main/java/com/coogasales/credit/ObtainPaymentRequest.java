package com.coogasales.credit;

import com.coogasales.CreditCardInfo;
import com.coogasales.Request;

public class ObtainPaymentRequest extends Request {
	private double paymentAmount;
	private CreditCardInfo paymentInfo;
	
	public double getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	
	public CreditCardInfo getPaymentInfo() {
		return paymentInfo;
	}
	public void setPaymentInfo(CreditCardInfo paymentInfo) {
		this.paymentInfo = paymentInfo;
	}
}
