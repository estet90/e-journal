package ru.salix.ejournal.api.model.api.filter;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class ExamMarkFilterDto {

    private Long id;
    private Long examId;
    private String pupilName;
    private String pupilSurname;
    private String pupilPatronymic;
    private String teacherName;
    private String teacherSurname;
    private String teacherPatronymic;
    private LocalDateTime datetimeFrom;
    private LocalDateTime datetimeTo;
    private String className;
    private String subject;

}
