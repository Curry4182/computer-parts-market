package kr.co.programmers.partsmarket.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
public class Order {

	private final UUID orderId;
	private String address;
	private String postcode;
	private OrderStatus orderStatus;
	private final List<OrderItem> orderItems;
	private final LocalDateTime createdAt;

	public Order(UUID orderId, String address, String postcode, OrderStatus orderStatus, List<OrderItem> orderItems,
		LocalDateTime createdAt) {
		this.orderId = orderId;
		this.address = address;
		this.postcode = postcode;
		this.orderStatus = orderStatus;
		this.orderItems = orderItems;
		this.createdAt = createdAt;
	}

	public UUID getOrderId() {
		return orderId;
	}

	public String getAddress() {
		return address;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
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
