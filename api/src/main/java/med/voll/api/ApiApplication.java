package med.voll.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * continuar no securityFilter na aular 5.5 recuperando token
 * continuar 2.2
 * 
 * para fazer os get pots e outros acesse
 * localhost:8080/swagger-ui.html
 * ex:
 * {
  		"page": 0,
  		"size": 3
	}
 */

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}

