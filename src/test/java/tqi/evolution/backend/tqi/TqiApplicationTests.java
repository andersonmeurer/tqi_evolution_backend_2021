package tqi.evolution.backend.tqi;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
class TqiApplicationTests {
	private TestRestTemplate restTemplate = new TestRestTemplate();
	private final ObjectMapper objectMapper = new ObjectMapper();
	private final String URL = "http://localhost:8080/tqi";

	@Test
	void contextLoads() {

		try {

			org.springframework.http.HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> httpRequest = new HttpEntity<>(objectMapper.writeValueAsString(""), httpHeaders);
			restTemplate.postForEntity(URL, httpRequest, String.class).getStatusCode();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}