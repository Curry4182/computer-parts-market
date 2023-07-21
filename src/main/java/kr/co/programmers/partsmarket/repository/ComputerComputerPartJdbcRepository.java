package kr.co.programmers.partsmarket.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import kr.co.programmers.partsmarket.model.ComputerPart;

public class ComputerComputerPartJdbcRepository implements ComputerPartRepository {

	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public ComputerComputerPartJdbcRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public List<ComputerPart> findAll() {
		return null;
	}

	@Override
	public ComputerPart insert(ComputerPart computerPart) {
		int insertedPartNum = namedParameterJdbcTemplate.update(
			"INSERT INTO parts(part_id, part_name, part_category, part_price, part_description, part_created_at"
			+ "VALUES (UNHEX(REPLACE(:partId, '-', '')), :partName, :partCategory, :partPrice, partDescription, partCreatedAt"
		, toParamMap(computerPart));

		return computerPart;
	}

	@Override
	public ComputerPart update(ComputerPart computerPart) {
		return null;
	}

	@Override
	public Optional<ComputerPart> findById(UUID partId) {
		return Optional.empty();
	}

	@Override
	public void deleteAll() {

	}

	private Map<String, Object> toParamMap(ComputerPart computerPart) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("partId", computerPart.getPartId().toString());
		paramMap.put("partName", computerPart.getPartName());
		paramMap.put("partCategory", computerPart.getPartCategory().toString());
		paramMap.put("partPrice", computerPart.getPartPrice());
		paramMap.put("partDescription", computerPart.getPartDescription());
		paramMap.put("partCreatedAt", computerPart.getPartCreatedAt());
		return paramMap;
	}
}
