package kr.co.programmers.partsmarket.service;

import java.util.List;

import kr.co.programmers.partsmarket.model.ComputerPart;
import kr.co.programmers.partsmarket.model.ComputerPartCategory;

public interface ComputerPartService {
	List<ComputerPart> getAllComputerParts();

	ComputerPart createComputerPart(String computerPartName, ComputerPartCategory computerPartCategory, int price,
		String description);
}
