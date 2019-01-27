package ru.salix.ejournal.api.controller.dto.filter;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class SubjectFilterDto {

    private Long id;
    private String name;
    private String teacherName;
    private String teacherSurname;
    private String teacherPatronymic;
    private String className;

}
