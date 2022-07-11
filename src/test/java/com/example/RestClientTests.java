package com.example;

import com.example.dto.RateQueryDTO;
import com.example.dto.RateResponseDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class RestClientTests {

	RestTemplate restTemplate = new RestTemplate();

	@BeforeAll
	static void runRestApp() {
		SpringApplication.run(TestInditexApplication.class);
	}

	@Test
	void tests() {

		test_query(LocalDateTime.of(2020, 6, 14, 10, 0), 1L);
		test_query(LocalDateTime.of(2020, 6, 14, 16, 0), 2L);
		test_query(LocalDateTime.of(2020, 6, 14, 21, 0), 1L);
		test_query(LocalDateTime.of(2020, 6, 15, 10, 0), 3L);
		test_query(LocalDateTime.of(2020, 6, 16, 21, 0), 4L);
	}

	private void test_query(LocalDateTime date, Long expectedId) {

		HttpEntity<RateQueryDTO> request = new HttpEntity<>(new RateQueryDTO(date, 35455L, 1L));
		ResponseEntity<RateResponseDTO> response = restTemplate.postForEntity("http://localhost:8080/rates/find", request,  RateResponseDTO.class);

		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertNotNull(response.getBody());
		assertEquals(response.getBody().getRateId(), expectedId);
	}

}
