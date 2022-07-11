package com.example;

import com.example.dto.RateQueryDTO;
import com.example.dto.RateResponseDTO;
import com.example.rest.RateController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ControllerTests {

	@Autowired
	RateController controller;

	@Test
	void tests() {

		test_query(LocalDateTime.of(2020, 6, 14, 10, 0), 1L);
		test_query(LocalDateTime.of(2020, 6, 14, 16, 0), 2L);
		test_query(LocalDateTime.of(2020, 6, 14, 21, 0), 1L);
		test_query(LocalDateTime.of(2020, 6, 15, 10, 0), 3L);
		test_query(LocalDateTime.of(2020, 6, 16, 21, 0), 4L);
	}

	private void test_query(LocalDateTime date, Long expectedId) {

		RateQueryDTO params = new RateQueryDTO(date, 35455L, 1L) ;

		ResponseEntity<RateResponseDTO> response = controller.find(params);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
		assertEquals(expectedId, response.getBody().getRateId());
	}

}
