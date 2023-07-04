package com.meleadr.Server;

import com.meleadr.Server.enumeration.Status;
import com.meleadr.Server.model.Server;
import com.meleadr.Server.repo.ServerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {

		SpringApplication.run(ServerApplication.class, args);
	}
	@Bean
	 CommandLineRunner runner(ServerRepo serverRepo) {
		return args -> {
			serverRepo.save(new Server(null, "192.168.0.1", "Server 1", "16GB", "Dedicated", "https://www.google.com", Status.SERVER_UP));
			serverRepo.save(new Server(null, "192.168.0.2", "Server 2", "16GB", "Dedicated", "https://www.google.com", Status.SERVER_UP));
			serverRepo.save(new Server(null, "192.168.0.3", "Server 3", "16GB", "Dedicated", "https://www.google.com", Status.SERVER_UP));
			serverRepo.save(new Server(null, "192.168.0.4", "Server 4", "16GB", "Dedicated", "https://www.google.com", Status.SERVER_UP));
		};
	 }
}
