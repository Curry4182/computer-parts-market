package kr.co.programmers.partsmarket.repository;

import java.nio.ByteBuffer;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.co.programmers.partsmarket.model.ComputerPart;
import kr.co.programmers.partsmarket.model.ComputerPartCategory;

@Repository
public class ComputerPartJdbcRepository implements ComputerPartRepository {

	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private RowMapper<ComputerPart> computerPartRowMapper = (ResultSet resultSet, int i) ->
	{
		var partId = toUUID(resultSet.getBytes("part_id"));
		var partName = resultSet.getString("part_name");
		var partCategory = ComputerPartCategory.valueOf(resultSet.getString("part_category"));
		var partPrice = resultSet.getInt("part_price");
		var partDescription = resultSet.getString("part_description");
		var partCreatedAt = toLocalDateTime(resultSet.getTimestamp("part_created_at"));
		return new ComputerPart(
			partId,
			partName,
			partCategory,
			partPrice,
			partDescription,
			partCreatedAt
		);
	};

	public ComputerPartJdbcRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	static public UUID toUUID(byte[] bytes) {
		var byteBuffer = ByteBuffer.wrap(bytes);
		return new UUID(byteBuffer.getLong(), byteBuffer.getLong());
	}

	static public LocalDateTime toLocalDateTime(Timestamp timestamp) {
		return timestamp != null ? timestamp.toLocalDateTime() : null;
	}

	@Override
	public List<ComputerPart> findAll() {
		return namedParameterJdbcTemplate.query("select * from computer_parts", computerPartRowMapper);
	}

	@Override
	public ComputerPart insert(ComputerPart computerPart) {
		int insertedPartNum = namedParameterJdbcTemplate.update(
			"INSERT INTO computer_parts(part_id, part_name, part_category, part_price, part_description, part_created_at)"
				+ " VALUES(UNHEX(REPLACE(:partId, '-', '')) , :partName, :partCategory, :partPrice, :partDescription, :partCreatedAt)"
			, toParamMap(computerPart));

		if (insertedPartNum != 1) {
			throw new RuntimeException("Nothing was inserted");
		}

		return computerPart;
	}

	@Override
	public ComputerPart update(ComputerPart computerPart) {
		int updatedComputerPartNum = namedParameterJdbcTemplate.update(
			"UPDATE computer_parts SET part_id = :partId, part_name = :partName, part_category = :partCategory, part_price = :partPrice, part_description = :partDescription, part_created_at = :partCreatedAt "
				+ " where part_id = :partId", toParamMap(computerPart)
		);

		if (updatedComputerPartNum < 1) {
			throw new RuntimeException("Nothing was updated!");
		}

		return computerPart;
	}

	@Override
	public ComputerPart findById(UUID partId) {
		return namedParameterJdbcTemplate.queryForObject(
			"SELECT * FROM computer_parts WHERE part_id = UNHEX(REPLACE(:partId, '-', ''))",
			Collections.singletonMap("partId", partId.toString().getBytes()), computerPartRowMapper);
	}

	@Override
	public void deleteAll() {
		namedParameterJdbcTemplate.update("DELETE FROM computerParts", Collections.EMPTY_MAP);
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
