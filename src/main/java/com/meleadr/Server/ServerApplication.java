package com.meleadr.Server;

import com.meleadr.Server.enumeration.Status;
import com.meleadr.Server.model.Server;
import com.meleadr.Server.repo.ServerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {

		SpringApplication.run(ServerApplication.class, args);
	}
	@Bean
	 CommandLineRunner runner(ServerRepo serverRepo) {
		return args -> {
			serverRepo.save(new Server(null, "192.168.0.1", "Server 1", "16GB", "Dedicated", "/assets/server.png", Status.SERVER_UP));
			serverRepo.save(new Server(null, "192.168.0.2", "Server 2", "8GB", "App Web", "/assets/server.png", Status.SERVER_UP));
			serverRepo.save(new Server(null, "192.168.0.3", "Server 3", "4GB", "Website", "/assets/server.png", Status.SERVER_UP));
			serverRepo.save(new Server(null, "192.168.0.4", "Server 4", "64GB", "Mutu", "/assets/server.png", Status.SERVER_UP));
		};
	 }

	 @Bean
	public CorsFilter corsFilter() {
		 UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		 CorsConfiguration corsConfiguration = new CorsConfiguration();
		 corsConfiguration.setAllowCredentials(true);
		 corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000","http://localhost:4200"));
		 corsConfiguration.setAllowedHeaders(Arrays.asList("Origin","Access-Control-Allow-Origin","Content-Type","Accept","Authorization","Origin, Accept","X-Requested-With","Access-Control-Request-Method","Access-Control-Request-Headers"));
		 corsConfiguration.setExposedHeaders(Arrays.asList("Origin","Content-Type","Accept","Authorization","Access-Control-Allow-Origin","Access-Control-Allow-Origin","Access-Control-Allow-Credentials"));
		 corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
		 urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
		 return new CorsFilter(urlBasedCorsConfigurationSource);
	 }
}
