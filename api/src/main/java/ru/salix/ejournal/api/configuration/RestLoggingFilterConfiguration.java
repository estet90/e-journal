package ru.salix.ejournal.api.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.salix.ejournal.api.configuration.filter.RequestResponseLoggingFilter;

@Configuration
public class RestLoggingFilterConfiguration {

    @Bean
    public FilterRegistrationBean someFilterRegistration(RequestResponseLoggingFilter filter) {
        var registration = new FilterRegistrationBean<RequestResponseLoggingFilter>();
        registration.setFilter(filter);
        return registration;
    }

}
