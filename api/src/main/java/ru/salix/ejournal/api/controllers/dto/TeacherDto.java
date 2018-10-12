package ru.salix.ejournal.api.controllers.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Builder
@Getter
@JsonInclude(NON_NULL)
public class TeacherDto {

    private long id;
    private String name;
    private String surname;
    private String patronymic;
    private String description;
    private List<SubjectDto> subjects;
    private List<SchoolClassDto> classes;

}
