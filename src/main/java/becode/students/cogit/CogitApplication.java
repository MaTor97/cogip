package becode.students.cogit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CogitApplication {

	public static void main(String[] args) {
		SpringApplication.run(CogitApplication.class, args);
	}
	@GetMapping
	public String hello() {
		return "Hello World";
	}
}
