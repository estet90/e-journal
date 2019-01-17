package ru.salix.ejournal.api.configuration.filter;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.Collections.list;
import static java.util.Optional.ofNullable;
import static org.springframework.util.CollectionUtils.isEmpty;
import static ru.salix.ejournal.api.constant.ThreadContextField.TRACE_ID;

@Log4j2
@Component
public class RequestResponseLoggingFilter extends OncePerRequestFilter {

    private static final String REQUEST_PREFIX = "|>";
    private static final String RESPONSE_PREFIX = "|<";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var wrapRequest = wrapRequest(request);
        var wrapResponse = wrapResponse(response);
        try {
            ThreadContext.put(TRACE_ID, UUID.randomUUID().toString());
            logRequestHeaders(wrapRequest);
            filterChain.doFilter(wrapRequest, wrapResponse);
            logRequestBody(wrapRequest);
        } finally {
            logResponseHeaders(wrapResponse);
            logResponseBody(wrapResponse);
            wrapResponse.copyBodyToResponse();
            ThreadContext.clearAll();
        }
    }

    private void logRequestHeaders(ContentCachingRequestWrapper request) {
        var query = ofNullable(request.getQueryString())
                .map(queryString -> String.format("%s %s?%s", request.getMethod(), request.getRequestURI(), queryString))
                .orElse(String.format("%s %s", request.getMethod(), request.getRequestURI()));
        var headers = list(request.getHeaderNames())
                .stream()
                .map(headerName -> headerName + "=" + list(request.getHeaders(headerName)))
                .collect(Collectors.joining("\r\n\t"));
        log.debug("{} query: {}\r\nheaders:\r\n\t{}", REQUEST_PREFIX, query, headers);

    }

    @SneakyThrows
    private void logRequestBody(ContentCachingRequestWrapper request) {
        var content = request.getContentAsByteArray();
        if (content.length > 0) {
            logContent(content, request.getContentType(), REQUEST_PREFIX);
        }
    }

    private void logResponseBody(ContentCachingResponseWrapper response) {
        var content = response.getContentAsByteArray();
        if (content.length > 0) {
            logContent(content, response.getContentType(), RESPONSE_PREFIX);
        }
    }

    private void logResponseHeaders(ContentCachingResponseWrapper response) {
        var status = String.format("%s %s", response.getStatus(), HttpStatus.valueOf(response.getStatus()).getReasonPhrase());
        if (!isEmpty(response.getHeaderNames())) {
            var headers = response.getHeaderNames()
                    .stream()
                    .map(headerName -> headerName + "=" + response.getHeaders(headerName));
            log.debug("{} status: {}\r\n\theaders:\t{}", RESPONSE_PREFIX, status, headers);
        } else {
            log.debug("{} status: {}", RESPONSE_PREFIX, status);
        }
    }

    private void logContent(byte[] content, String contentType, String prefix) {
        var mediaType = MediaType.valueOf(contentType);
        if (mediaType.includes(MediaType.APPLICATION_JSON) || mediaType.includes(MediaType.APPLICATION_XML)) {
            log.debug("{} body: {}", prefix, new String(content, UTF_8));
        } else {
            log.debug("{} body:[{} bytes content]", prefix, content.length);
        }
    }

    private ContentCachingRequestWrapper wrapRequest(HttpServletRequest request) {
        return request instanceof ContentCachingRequestWrapper
                ? (ContentCachingRequestWrapper) request
                : new ContentCachingRequestWrapper(request);
    }

    private ContentCachingResponseWrapper wrapResponse(HttpServletResponse response) {
        return response instanceof ContentCachingResponseWrapper
                ? (ContentCachingResponseWrapper) response
                : new ContentCachingResponseWrapper(response);
    }
}