package ru.salix.ejournal.api.model.api.filter;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TimetableFilterDto {

    private Long id;
    private String className;
    private String subject;
    private String teacherName;
    private String teacherSurname;
    private String teacherPatronymic;
    private String pupilName;
    private String pupilSurname;
    private String pupilPatronymic;
    private Integer lessonPeriodNumber;
    private Integer lessonPeriodShift;

}
