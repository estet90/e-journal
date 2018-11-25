package ru.salix.ejournal.api.controllers.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class TeacherDto {

    private long id;
    private String name;
    private String surname;
    private String patronymic;
    private String description;
    private List<SubjectDto> subjects;
    private List<SchoolClassDto> classes;

}
