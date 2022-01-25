package com.demo.cars;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CarsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CarsApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testNotNullResponse() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange("http://localhost:" + port + "/cars", HttpMethod.GET,
				entity, String.class);

		Assert.assertNotNull(response.getBody());
	}

	@Test
	public void testGetAllCars() {

		ResponseEntity <List<Car>> response = restTemplate.exchange("http://localhost:" + port + "/cars",
    		HttpMethod.GET, null, new ParameterizedTypeReference <List<Car>> () {});

		List <Car> cars = response.getBody();
		Assert.assertNotNull(cars);
		Assert.assertEquals(6, cars.size());
		Assert.assertEquals("Mercedes GLA", cars.get(0).getName());
	}

	@Test
	public void testGetStatus() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange("http://localhost:" + port + "/status", HttpMethod.GET,
				entity, String.class);

		Assert.assertNotNull(response.getBody());
		Assert.assertEquals("NotOK", response.getBody());
	}

}
