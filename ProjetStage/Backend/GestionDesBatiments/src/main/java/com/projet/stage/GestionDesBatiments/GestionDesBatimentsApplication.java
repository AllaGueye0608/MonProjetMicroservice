package com.projet.stage.GestionDesBatiments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GestionDesBatimentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionDesBatimentsApplication.class, args);
	}

}
