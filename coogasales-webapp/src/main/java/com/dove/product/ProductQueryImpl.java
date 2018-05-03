package com.dove.product;

public class ProductQueryImpl implements ProductQueryService {

	public ValidateProductIDResponse validateProductID(ValidateProductIDRequest request) {
		// TODO Auto-generated method stub
		ValidateProductIDResponse response = new ValidateProductIDResponse();
		response.setProductID("test product id");
		response.setValid(true);
		
		return response;
	}

}
