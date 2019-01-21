package ru.salix.ejournal.api.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SchoolClassDto {

    private Long id;
    private int number;
    private char liter;
    private TeacherDto teacher;
    private PeriodDto period;
    //TODO: timetables
}
