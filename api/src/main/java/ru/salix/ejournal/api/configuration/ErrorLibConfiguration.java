package ru.salix.ejournal.api.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.salix.ejournal.error.exception.ExceptionFactory;

@Configuration
public class ErrorLibConfiguration {

    @Bean
    ExceptionFactory exceptionFactory(@Value("${spring.application.name}") String serviceCode) {
        return new ExceptionFactory(serviceCode);
    }

}
