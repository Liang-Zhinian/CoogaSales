package com.coogasales.product;

import com.coogasales.Request;

public class ValidateProductIDRequest extends Request {
	
	private String productID;
	
	public String getProductID() {
		return productID;
	}
	
	public void setProductID(String productID) {
		this.productID = productID;
	}
}
