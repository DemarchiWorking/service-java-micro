package com.example.servico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ServicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicoApplication.class, args);
	}

}
