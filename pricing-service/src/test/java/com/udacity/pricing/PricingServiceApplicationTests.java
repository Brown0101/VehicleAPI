package com.udacity.pricing;

import com.udacity.pricing.api.PricingController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // Used for integration tests and use a random port to avoid conflicts.
@AutoConfigureMockMvc // Simulates calling code from the client as if we were calling a real http request.
public class PricingServiceApplicationTests {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate; // Allows use of testing rest API's programmatically.

	@Test
	public void getVehiclePrice() {
		ResponseEntity<String> response =
				this.restTemplate.getForEntity("http://localhost:" + port + "/services/price?vehicleId=1", String.class);

		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	}

}
