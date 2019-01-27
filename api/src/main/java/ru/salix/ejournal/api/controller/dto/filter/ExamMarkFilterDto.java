package ru.salix.ejournal.api.controller.dto.filter;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
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
