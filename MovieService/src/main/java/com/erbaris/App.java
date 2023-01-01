package com.erbaris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"org.csystem", "com.erbaris"})
public class App {
	public static void main(String[] args)
	{
		SpringApplication.run(App.class, args);
	}
}
