package alotra.milktea;

import alotra.milktea.service.Interfaces.IStorageService;
import config.StorageProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class MilkTeaShopsChainManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MilkTeaShopsChainManagementApplication.class, args);
	}
	@Bean
	CommandLineRunner init(IStorageService storageService) {
		return(args -> {
			storageService.init();
		});
	}
}
