package com.magneto.servicemutant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceMutantApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceMutantApplication.class, args);
	}

}
