package com.p7.mse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties
@ComponentScan(basePackages = {"com.p7.mse.entity.Emprunt", "com.p7.mse.controlleur.EmpruntController"})
public class MsEmpruntApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsEmpruntApplication.class, args);
	}

}
