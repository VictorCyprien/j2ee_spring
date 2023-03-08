package fr.limayrac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
//@ComponentScan (basePackages = {"fr.limayrac.aspect", "fr.limayrac.controller"})
public class SecuriteJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuriteJdbcApplication.class, args);
	}

}
