package kr.co.programmers.partsmarket.repository;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import kr.co.programmers.partsmarket.model.ComputerPart;
import kr.co.programmers.partsmarket.model.ComputerPartCategory;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ComputerPartJdbcRepositoryTest {

	@Autowired
	ComputerPartRepository computerPartRepository;

	private ComputerPart newComputerPart = new ComputerPart(
		UUID.randomUUID(),
		"AMD 라이젠7 4세대 5700X (버미어) (멀티팩(정품))",
		ComputerPartCategory.CPU,
		352324,
		"AMD(소켓AM5)/5세대(Zen4)/5nm/6코어/12쓰레드/기본 클럭:3.8GHz/최대 클럭:5.1GHz/L2 캐시:6MB/L3 캐시:32MB/TDP:65W/PPT:88W/PCIe5.0/메모리 규격:DDR5/5200MHz/내장그래픽:탑재/AMD 라데온 그래픽/쿨러:Wraith Stealth 포함",
		LocalDateTime.now()
	);

	@Test
	@Order(0)
	@DisplayName("상품을 모두 제거 할 수 있다.")
	void deleteAll() {
		computerPartRepository.deleteAll();
		List<ComputerPart> all = computerPartRepository.findAll();
		assertThat(all.isEmpty(), is(true));
	}

	@Test
	@DisplayName("상품을 추가할 수 있다.")
	void testInsert() {
		computerPartRepository.insert(newComputerPart);
		List<ComputerPart> all = computerPartRepository.findAll();
		assertThat(all.isEmpty(), is(false));
	}
}