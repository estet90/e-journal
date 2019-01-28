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
public class TeacherDto extends BaseDtoEntity {

    private String name;
    private String surname;
    private String patronymic;
    private String description;
    private List<SubjectDto> subjects;
    private List<SchoolClassDto> classes;
    private List<TimetableDto> timetables;

}
