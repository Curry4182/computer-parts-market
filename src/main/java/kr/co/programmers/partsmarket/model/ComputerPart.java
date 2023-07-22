package kr.co.programmers.partsmarket.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class ComputerPart {
	private final UUID partId;
	private final LocalDateTime partCreatedAt;
	private String partName;
	private ComputerPartCategory partCategory;
	private int partPrice;
	private String partDescription;

	public ComputerPart(UUID partId, String partName, ComputerPartCategory partCategory, int partPrice,
		String partDescription,
		LocalDateTime partCreatedAt) {
		this.partId = partId;
		this.partName = partName;
		this.partCategory = partCategory;
		this.partPrice = partPrice;
		this.partDescription = partDescription;
		this.partCreatedAt = partCreatedAt;
	}

	public UUID getPartId() {
		return partId;
	}

	public String getPartName() {
		return partName;
	}

	public int getPartPrice() {
		return partPrice;
	}

	public String getPartDescription() {
		return partDescription;
	}

	public ComputerPartCategory getPartCategory() {
		return partCategory;
	}

	public LocalDateTime getPartCreatedAt() {
		return partCreatedAt;
	}
}
