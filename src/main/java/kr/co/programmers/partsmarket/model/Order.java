package kr.co.programmers.partsmarket.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
public class Order {

	private final UUID orderId;
	private String address;
	private String postcode;
	private final List<OrderItem> orderItems;
	private final LocalDateTime createdAt;

	public Order(UUID orderId, String address, String postcode, List<OrderItem> orderItems, LocalDateTime createdAt) {
		this.orderId = orderId;
		this.address = address;
		this.postcode = postcode;
		this.orderItems = orderItems;
		this.createdAt = createdAt;
	}

	public UUID getOrderId() {
		return orderId;
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
}
