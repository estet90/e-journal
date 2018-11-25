package ru.salix.ejournal.api.controllers.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class SubjectDto {

    private long id;
    private String name;
    private List<TeacherDto> teachers;

}
