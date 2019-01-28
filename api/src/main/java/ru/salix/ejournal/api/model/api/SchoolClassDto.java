package ru.salix.ejournal.api.model.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SchoolClassDto extends BaseDtoEntity {

    private int number;
    private char liter;
    private TeacherDto teacher;
    private PeriodDto period;
    private List<TimetableDto> timetables;
    private List<PupilDto> pupils;

}
