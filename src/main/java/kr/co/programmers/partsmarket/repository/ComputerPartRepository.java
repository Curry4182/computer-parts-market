package kr.co.programmers.partsmarket.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import kr.co.programmers.partsmarket.model.ComputerPart;

public interface ComputerPartRepository {
	List<ComputerPart> findAll();
	ComputerPart insert(ComputerPart computerPart);
	ComputerPart update(ComputerPart computerPart);
	Optional<ComputerPart> findById(UUID partId);
	void deleteAll();
}
