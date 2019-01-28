package ru.salix.ejournal.api.model.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TimetableDto extends BaseDtoEntity {

    private SchoolClassDto schoolClass;
    private SubjectDto subject;
    private TeacherDto teacher;
    private LessonPeriodDto lessonPeriod;
    private PeriodDto period;
    private int dayOfWeek;

}
