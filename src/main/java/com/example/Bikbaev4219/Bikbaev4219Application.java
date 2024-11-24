package com.example.Bikbaev4219;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan(basePackages = "com.example.Bikbaev4219")
@EnableJpaRepositories("com.example.Bikbaev4219")
public class Bikbaev4219Application {

	public static void main(String[] args) {
		SpringApplication.run(Bikbaev4219Application.class, args);
	}

	@Bean
	public String address1() {
		return "Green Street, 102";
	}

	@Bean
	public String address2() {
		return "Apple Street, 15";
	}

	@Bean
	public Customer customer(@Qualifier("address2") String address) {
		return new Customer("Clara Foster", address);
	}

	@Bean
	public Customer temporary(@Autowired Customer customer) {
		System.out.println(customer);
		return customer;
	}

}
