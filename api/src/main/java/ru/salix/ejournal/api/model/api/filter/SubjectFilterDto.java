package ru.salix.ejournal.api.model.api.filter;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SubjectFilterDto {

    private Long id;
    private String name;
    private String teacherName;
    private String teacherSurname;
    private String teacherPatronymic;
    private String className;

}
