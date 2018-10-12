package ru.salix.ejournal.api.controllers.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Builder
@Getter
@JsonInclude(NON_NULL)
public class SchoolClassDto {

    private long id;
    private int number;
    private char liter;
    private TeacherDto teacher;
    private PeriodDto period;

}
