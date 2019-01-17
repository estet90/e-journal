package ru.salix.ejournal.api.controller.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SchoolClassDto {

    private long id;
    private int number;
    private char liter;
    private TeacherDto teacher;
    private PeriodDto period;

}
