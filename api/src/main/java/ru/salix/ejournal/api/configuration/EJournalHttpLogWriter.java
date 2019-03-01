package ru.salix.ejournal.api.configuration;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.zalando.logbook.Correlation;
import org.zalando.logbook.HttpLogWriter;
import org.zalando.logbook.Precorrelation;

import javax.annotation.Nonnull;

import static ru.salix.ejournal.api.constant.ThreadContextField.TRACE_ID;

public class EJournalHttpLogWriter implements HttpLogWriter {

    private final Logger logger;

    EJournalHttpLogWriter(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void writeRequest(@Nonnull Precorrelation<String> precorrelation) {
        ThreadContext.put(TRACE_ID, precorrelation.getId());
        logger.debug(precorrelation.getRequest());
    }

    @Override
    public void writeResponse(@Nonnull Correlation<String, String> correlation) {
        logger.debug(correlation.getResponse());
        ThreadContext.clearAll();
    }

}
