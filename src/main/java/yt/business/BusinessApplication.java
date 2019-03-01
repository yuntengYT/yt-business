package yt.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;

/**
 * BusinessApplication
 *
 * @author yt
 */
@EnableTransactionManagement(proxyTargetClass = true)
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@RestController
@ComponentScan(basePackages = "yt.business")
@EnableScheduling
public class BusinessApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinessApplication.class, args);
	}
}
