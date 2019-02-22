package ru.salix.ejournal.api.model.api.filter;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class HomeworkFilterDto {

    private Long id;
    private String pupilName;
    private String pupilSurname;
    private String pupilPatronymic;
    private String teacherName;
    private String teacherSurname;
    private String teacherPatronymic;
    private LocalDate dateReceiveFrom;
    private LocalDate dateReceiveTo;
    private LocalDate dateCompleteFrom;
    private LocalDate dateCompleteTo;
    private String className;
    private String subject;

}
