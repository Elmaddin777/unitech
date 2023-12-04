package az.unitech.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("az.unitech.app.client")
public class UnitechApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnitechApplication.class, args);
	}

}
