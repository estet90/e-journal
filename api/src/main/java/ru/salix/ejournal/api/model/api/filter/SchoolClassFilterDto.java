package ru.salix.ejournal.api.model.api.filter;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SchoolClassFilterDto {

    private Long id;
    private String name;
    private String pupilName;
    private String pupilSurname;
    private String pupilPatronymic;
    private String teacherName;
    private String teacherSurname;
    private String teacherPatronymic;
    private String subject;

}
