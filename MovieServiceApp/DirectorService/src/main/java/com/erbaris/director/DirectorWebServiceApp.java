package com.erbaris.director;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.erbaris", "org.csystem"})
public class DirectorWebServiceApp {
	public static void main(String[] args)
	{
		SpringApplication.run(DirectorWebServiceApp.class, args);
	}
}
