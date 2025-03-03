package uasz.sn.microservice_emploiDuTemps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class MicroserviceEmploiDuTempsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceEmploiDuTempsApplication.class, args);
	}

}
