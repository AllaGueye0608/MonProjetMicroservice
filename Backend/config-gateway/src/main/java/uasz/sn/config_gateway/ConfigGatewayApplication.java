package uasz.sn.config_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;


@EnableDiscoveryClient
@SpringBootApplication
public class ConfigGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigGatewayApplication.class, args);
	}
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("service-maquette", r -> r.path("/maquettes/**", "/ues/**", "/ecs/**", "/enseignements/**", "/classes/**", "/formations/**")
						.uri("http://localhost:8085"))
				.route("service-repartition", r -> r.path("/choix/**")
						.uri("http://localhost:8082"))
				.route("service-emploiDuTemps", r -> r.path("/seances/**", "/salles/**", "/batiments/**")
						.uri("http://localhost:8083"))
				.route("service-utilisateur", r -> r.path("/users/**", "/etudiants/**", "/enseignants/**", "/permanents/**", "/vacataires/**")
						.uri("http://localhost:8084"))
				.build();
	}
}
