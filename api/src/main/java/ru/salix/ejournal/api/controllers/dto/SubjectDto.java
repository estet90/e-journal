package ru.salix.ejournal.api.controllers.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Builder
@Getter
@JsonInclude(NON_NULL)
public class SubjectDto {

    private long id;
    private String name;
    private List<TeacherDto> teachers;

}
