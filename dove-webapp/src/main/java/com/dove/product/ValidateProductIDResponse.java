package com.dove.product;

import com.dove.Response;

public class ValidateProductIDResponse extends Response {

	
	private String productID;
	private Boolean valid;
	
	public String getProductID() {
		return productID;
	}
	
	public void setProductID(String productID) {
		this.productID = productID;
	}
	
	public Boolean getValid() {
		return valid;
	}
	
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
}
