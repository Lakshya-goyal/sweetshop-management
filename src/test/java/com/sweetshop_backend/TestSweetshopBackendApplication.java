package com.sweetshop_backend;

import org.springframework.boot.SpringApplication;

public class TestSweetshopBackendApplication {

	public static void main(String[] args) {
		SpringApplication.from(SweetshopBackendApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
