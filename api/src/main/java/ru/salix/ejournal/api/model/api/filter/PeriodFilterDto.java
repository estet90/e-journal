package ru.salix.ejournal.api.model.api.filter;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class PeriodFilterDto {

    private Long id;
    private String periodType;
    private LocalDate dateStartFrom;
    private LocalDate dateStartTo;
    private LocalDate dateEndFrom;
    private LocalDate dateEndTo;

}
