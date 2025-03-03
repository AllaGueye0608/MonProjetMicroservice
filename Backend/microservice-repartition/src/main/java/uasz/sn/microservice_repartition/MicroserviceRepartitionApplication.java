package uasz.sn.microservice_repartition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceRepartitionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceRepartitionApplication.class, args);
	}

}
