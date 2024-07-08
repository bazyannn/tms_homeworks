package org.springmvc.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.postgresql.Driver;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ServletConfig implements WebApplicationInitializer {

    static {
        try {
            DriverManager.registerDriver(new Driver());

            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/filmoteka?user=bazyan&password=z11411985z");

            Statement statement = connection.createStatement();

            statement.execute("create table if not exists films(\n" +
                    "    id uuid primary key,\n" +
                    "    title varchar,\n" +
                    "    description varchar,\n" +
                    "    genre varchar,\n" +
                    "    year int,\n" +
                    "    is_Viewed boolean\n" +
                    ");");

            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(AppConfig.class);
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", dispatcherServlet);

        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}
