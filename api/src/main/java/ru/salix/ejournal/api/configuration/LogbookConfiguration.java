package ru.salix.ejournal.api.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.logbook.DefaultHttpLogFormatter;
import org.zalando.logbook.Logbook;

@Configuration
public class LogbookConfiguration {

    private final Logger logger = LogManager.getLogger("ru.salix.ejournal.api.HttpLogger");

    @Bean
    Logbook logbook() {
        return Logbook.builder()
                .formatter(new DefaultHttpLogFormatter())
                .writer(new EJournalHttpLogWriter(logger))
                .build();
    }

}
