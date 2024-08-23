package com.example.springbootthymeleaf39;

import com.example.springbootthymeleaf39.domain.ToolEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

@SpringBootApplication
public class SpringbootThymeleaf39Application {

	public static void main(String[] args) {

		SpringApplication.run(SpringbootThymeleaf39Application.class, args);

		}
		@Bean
		public SessionFactory sessionFactory() {

			Configuration configuration = new Configuration();
			Properties properties = new Properties();
			properties.put("hibernate.connection.url", "jdbc:postgresql://localhost:5432/springboot-thymeleaf");
			properties.put("hibernate.connection.username", "bazyan");
			properties.put("hibernate.connection.password", "z11411985z");
			properties.put("hibernate.connection.driver_class", "org.postgresql.Driver");
			properties.put("hibernate.show_sql", true);
			properties.put("hibernate.hbm2ddl.auto", "update");
			configuration.addProperties(properties);
			configuration.addAnnotatedClass(ToolEntity.class);
			return configuration.buildSessionFactory();
		}

	}


