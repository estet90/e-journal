package ru.salix.ejournal.api.model.api.filter;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class ExamFilterDto {

    private Long id;
    private LocalDateTime datetimeFrom;
    private LocalDateTime datetimeTo;
    private String className;
    private String subject;
    private String teacherName;
    private String teacherSurname;
    private String teacherPatronymic;

}
