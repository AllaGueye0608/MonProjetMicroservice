package uasz.sn.microservice_repartition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import uasz.sn.microservice_repartition.model.Enseignant;
import uasz.sn.microservice_repartition.service.EnseignantService;
import uasz.sn.microservice_repartition.service.EnseignementService;
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableScheduling
public class MicroserviceRepartitionApplication implements CommandLineRunner {
	@Autowired
	private EnseignementService enseignementService;
	@Autowired
	private EnseignantService enseignantService;

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceRepartitionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		enseignementService.saveAll();
		Enseignant modou = new Enseignant();modou.setNom("Gueye");modou.setPrenom("Modou");
		Enseignant abdou = new Enseignant();abdou.setNom("SENE");abdou.setPrenom("Abdou");
		enseignantService.save(modou);enseignantService.save(abdou);
	}
}
