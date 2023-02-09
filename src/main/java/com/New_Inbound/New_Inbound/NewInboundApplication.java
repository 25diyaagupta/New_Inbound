package com.New_Inbound.New_Inbound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NewInboundApplication {

	@Autowired
	private TableCreator tableCreator;

	public static void main(String[] args) {
		SpringApplication.run(NewInboundApplication.class, args);
	}

}
