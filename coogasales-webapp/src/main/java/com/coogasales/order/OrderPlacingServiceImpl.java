package com.coogasales.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.coogasales.Customer;
import com.coogasales.SalesOrder;
import com.coogasales.SalesOrderLineItem;
import com.coogasales.credit.ObtainPaymentRequest;
import com.coogasales.credit.ObtainPaymentResponse;
import com.coogasales.credit.ObtainPaymentService;
import com.coogasales.credit.ObtainPaymentServiceImpl;
import com.coogasales.customer.CustomerQueryService;
import com.coogasales.customer.CustomerQueryServiceImpl;
import com.coogasales.customer.GetCustomerRequest;
import com.coogasales.customer.GetCustomerResponse;
import com.coogasales.product.ProductQueryService;
import com.coogasales.product.ProductQueryServiceImpl;
import com.coogasales.product.ValidateProductIDRequest;
import com.coogasales.product.ValidateProductIDResponse;


public class OrderPlacingServiceImpl implements OrderPlacingService {
	private ProductQueryService productQueryService = new ProductQueryServiceImpl();
	private CustomerQueryService customerQueryService = new CustomerQueryServiceImpl();
	private ObtainPaymentService obtainPaymentService = new ObtainPaymentServiceImpl();
	private OrderFulfillmentService orderFulfillmentService = new OrderFulfillmentServiceImpl();
	
	
	public PlaceOrderResponse placeOrder(PlaceOrderRequest request) {
		PlaceOrderResponse placeOrderResponse;
		List<SalesOrderRequestItem> salesItems = request.getSalesItems();
		
		// validate each order item
		for(int i=0; i<salesItems.size(); i++) {
			String productID = salesItems.get(i).getItemID();
			ValidateProductIDRequest validateProductIDRequest = new ValidateProductIDRequest();
			validateProductIDRequest.setProductID(productID);
			ValidateProductIDResponse validateProductIDResponse = productQueryService.validateProductID(validateProductIDRequest);
			if (!validateProductIDResponse.getValid()) {
				placeOrderResponse = new RejectedSalesOrderResponse();
				placeOrderResponse.setOrderAccepted(false);
				((RejectedSalesOrderResponse)placeOrderResponse).setRejectionReason("Product #"+productID+" is not valid.");
				return placeOrderResponse;
			}
		}
		
		// get customer info
		GetCustomerRequest getCustomerRequest = new GetCustomerRequest();
		getCustomerRequest.setCustomerID(request.getCustomerID());
		GetCustomerResponse getCustomerResponse = customerQueryService.getCustomer(getCustomerRequest);
		
		// calculate payment amount
		double paymentAmount = 0;
		for(int i=0; i<salesItems.size(); i++) {
			SalesOrderRequestItem item = salesItems.get(i);
			paymentAmount = paymentAmount + item.getPrice() * item.getQuantity();
		}
		
		// charge customer's credit card
		ObtainPaymentRequest obtainPaymentRequest = new ObtainPaymentRequest();
		obtainPaymentRequest.setPaymentInfo(request.getPaymentInfo());
		obtainPaymentRequest.setPaymentAmount(paymentAmount);
		ObtainPaymentResponse obtainPaymentResponse = obtainPaymentService.obtainPayment(obtainPaymentRequest);
		if (!obtainPaymentResponse.getPaymentObtained()) {
			placeOrderResponse = new RejectedSalesOrderResponse();
			placeOrderResponse.setOrderAccepted(false);
			((RejectedSalesOrderResponse)placeOrderResponse).setRejectionReason("Order not paid.");
			return placeOrderResponse;
		}
		
		// save and acknowledge order
		String orderID = "order-xxx";
		
		// fill oder
		SalesOrder salesOrder = new SalesOrder();
		salesOrder.setOrderID(orderID);
		salesOrder.setDatePlaced(new Date());
		salesOrder.setStatus("placed");
		salesOrder.setBillingAddress(request.getBillingAddress());
		salesOrder.setShippingAddress(request.getShippingAddress());
		
		List<SalesOrderLineItem> lineItems = new ArrayList<SalesOrderLineItem>();
		for(int i=0; i<salesItems.size(); i++) {
			SalesOrderRequestItem item = salesItems.get(i);
			SalesOrderLineItem lineItem = new SalesOrderLineItem();
			lineItem.setItemID(item.getItemID());
			lineItem.setPrice(item.getPrice());
			lineItem.setQuantity(item.getQuantity());
			lineItems.add(lineItem);
			
		}
		salesOrder.setLineItems(lineItems);
		
		Customer customer = getCustomerResponse.getCustomer();
		FillOrderRequest fillOrderRequest = new FillOrderRequest();
		fillOrderRequest.setCustomerID(customer.getCustomerID());
		fillOrderRequest.setCustomerName(customer.getName());
		fillOrderRequest.setSalesOrder(salesOrder);
		orderFulfillmentService.fillOrder(fillOrderRequest);

		placeOrderResponse = new AcceptedSalesOrderResponse();
		placeOrderResponse.setOrderAccepted(false);
		((AcceptedSalesOrderResponse)placeOrderResponse).setOrderID(orderID);
		return placeOrderResponse;
	}
}
