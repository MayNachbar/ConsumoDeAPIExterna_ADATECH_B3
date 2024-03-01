package com.adatech.ConsumoDeAPIExterna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ConsumoDeApiExternaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumoDeApiExternaApplication.class, args);
	}

}
