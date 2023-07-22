package kr.co.programmers.partsmarket.model;

import java.time.LocalDateTime;
import java.util.UUID;
public class OrderItem {
	private final UUID partId;
	private ComputerPartCategory partCategory;
	private long price;
	private int quantity;
	private LocalDateTime created_at;

	public OrderItem(UUID partId, ComputerPartCategory partCategory, long price, int quantity,
		LocalDateTime created_at) {
		this.partId = partId;
		this.partCategory = partCategory;
		this.price = price;
		this.quantity = quantity;
		this.created_at = created_at;
	}

	public UUID getPartId() {
		return partId;
	}

	public ComputerPartCategory getPartCategory() {
		return partCategory;
	}

	public long getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}
}
