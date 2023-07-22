package kr.co.programmers.partsmarket.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import kr.co.programmers.partsmarket.model.ComputerPart;
import kr.co.programmers.partsmarket.model.ComputerPartCategory;
import kr.co.programmers.partsmarket.repository.ComputerPartRepository;

@Service
public class DefaultComputerPartService implements ComputerPartService {

	private final ComputerPartRepository computerPartRepository;

	public DefaultComputerPartService(ComputerPartRepository computerPartRepository) {
		this.computerPartRepository = computerPartRepository;
	}

	@Override
	public List<ComputerPart> getAllComputerParts() {
		return computerPartRepository.findAll();
	}

	@Override
	public ComputerPart createComputerPart(String computerPartName, ComputerPartCategory computerPartCategory,
		int price, String description) {
		ComputerPart newComputerPart = new ComputerPart(
			UUID.randomUUID(),
			computerPartName,
			computerPartCategory,
			price,
			description,
			LocalDateTime.now()
		);
		computerPartRepository.insert(newComputerPart);
		return newComputerPart;
	}
}
