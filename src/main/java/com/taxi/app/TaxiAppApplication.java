package com.taxi.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;

/**
 * GoRide - Taxi Ride-Hailing Application.
 * Spring Boot entry point. On startup, logs the running URL.
 */
@SpringBootApplication
public class TaxiAppApplication {

	private final Environment env;

	public TaxiAppApplication(Environment env) {
		this.env = env;
	}

	public static void main(String[] args) {
		SpringApplication.run(TaxiAppApplication.class, args);
	}

	/** Print the application URL once the server is ready. */
	@EventListener(ApplicationReadyEvent.class)
	public void onReady() {
		String port = env.getProperty("server.port", "8090");
		System.out.println(">>> GoRide app is running at http://localhost:" + port);
	}
}
