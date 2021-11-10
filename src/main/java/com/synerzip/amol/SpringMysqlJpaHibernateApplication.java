package com.synerzip.amol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaAuditing
public class SpringMysqlJpaHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMysqlJpaHibernateApplication.class, args);
	}

}
