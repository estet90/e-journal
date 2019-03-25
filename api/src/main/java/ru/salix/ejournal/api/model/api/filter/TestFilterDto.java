package ru.salix.ejournal.api.model.api.filter;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class TestFilterDto {

    private Long id;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private String subject;
    private String className;

}
