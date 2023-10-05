package fr.humanbooster.fx.plage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import fr.humanbooster.fx.plage.util.CorsConfig;

@SpringBootApplication
@EnableScheduling
@Import(CorsConfig.class)
public class PlageApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlageApplication.class, args);
	}

}
