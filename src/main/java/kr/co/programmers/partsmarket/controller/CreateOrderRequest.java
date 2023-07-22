package kr.co.programmers.partsmarket.controller;

import java.util.List;

import kr.co.programmers.partsmarket.model.OrderItem;

public class CreateOrderRequest {
	private String address;
	private String postcode;
	private List<OrderItem> orderItems;

	public CreateOrderRequest(String address, String postcode, List<OrderItem> orderItems) {
		this.address = address;
		this.postcode = postcode;
		this.orderItems = orderItems;
	}

	public String getAddress() {
		return address;
	}

	public String getPostcode() {
		return postcode;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
}
