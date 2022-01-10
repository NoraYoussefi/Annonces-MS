package lsi.fstt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
@EnableEurekaClient
@ComponentScan({"fstt.lsi.dao","fstt.lsi.entities","fstt.lsi.metier","fstt.lsi.services", "fstt.lsi.feign" })
@SpringBootApplication(scanBasePackages={"fstt.lsi.dao","fstt.lsi.entities","fstt.lsi.feign","fstt.lsi.metier","fstt.lsi.services"})  //scanner les packages de l'app
@EntityScan("fstt.lsi.entities")
@EnableMongoRepositories( basePackages = "fstt.lsi.dao")
@EnableFeignClients(basePackages ="fstt.lsi.feign")
public class AnnoncesMs1Application {

	public static void main(String[] args) {
		SpringApplication.run(AnnoncesMs1Application.class, args);
	}

}
