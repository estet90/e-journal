package ru.salix.ejournal.api.model.api.filter;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class PeriodMarkFilterDto {

    private Long id;
    private String periodTypeName;
    private String pupilName;
    private String pupilSurname;
    private String pupilPatronymic;
    private String teacherName;
    private String teacherSurname;
    private String teacherPatronymic;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private String className;
    private String subject;

}
