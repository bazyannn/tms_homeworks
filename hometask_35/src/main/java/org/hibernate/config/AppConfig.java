package org.hibernate.config;

import org.hibernate.domain.PersonEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;


public class AppConfig {

    public SessionFactory sessionFactory() {

        Configuration configuration = new Configuration();
        Properties properties = new Properties();
        properties.put("hibernate.connection.url", "jdbc:postgresql://localhost:5432/hibernate");
        properties.put("hibernate.connection.username", "bazyan");
        properties.put("hibernate.connection.password", "z11411985z");
        properties.put("hibernate.connection.driver_class", "org.postgresql.Driver");
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.hbm2ddl.auto", "create");
        configuration.addProperties(properties);
        configuration.addAnnotatedClass(PersonEntity.class);
        return configuration.buildSessionFactory();
    }
}
