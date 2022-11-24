package com.example.springcloudserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringcloudserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudserverApplication.class, args);
	}

}
