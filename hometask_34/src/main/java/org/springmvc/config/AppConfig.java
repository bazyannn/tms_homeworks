/*Доп улучшаем проект - Фильмотека.
        Необходимо сделать правильную обработку ошибок пользовательского ввода - если пользователь введен некорректные данные (придумать любые условия), то необходимо на этой же страницы ему об этом сообщить и не затирать то, что он ввел уже.
        Так же стоит сделать глобальный обработчик ошибок, которые бросаются контроллерами.
        Доп задание (не обязательное) - реализовать локализацию страниц/страницы (можно часть)*/

package org.springmvc.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Locale;


@Configuration
@ComponentScan("org.springmvc")

public class AppConfig {

    @Bean
    public ViewResolver viewResolver () {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.US);
        return localeResolver;
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
        source.setBasename("classpath:/messages");
        source.setDefaultEncoding("UTF-8");
        return source;
    }

}
