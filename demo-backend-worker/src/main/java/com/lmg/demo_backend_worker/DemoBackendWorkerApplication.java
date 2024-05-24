package com.lmg.demo_backend_worker;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class DemoBackendWorkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoBackendWorkerApplication.class, args);
	}

}
