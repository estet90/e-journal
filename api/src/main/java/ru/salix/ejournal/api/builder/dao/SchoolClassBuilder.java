package ru.salix.ejournal.api.builder.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.SchoolClassMapper;
import ru.salix.ejournal.api.model.api.SchoolClassDto;
import ru.salix.ejournal.api.model.dao.SchoolClass;

@Component
@RequiredArgsConstructor
public class SchoolClassBuilder extends AbstractDaoBuilder<SchoolClass, SchoolClassDto> {

    private final SchoolClassMapper schoolClassMapper;

    private final PeriodBuilder periodBuilder;
    private final PupilBuilder pupilBuilder;
    private final TeacherBuilder teacherBuilder;
    private final TimetableBuilder timetableBuilder;

    @Override
    public SchoolClass build(SchoolClassDto schoolClassDto) {
        return schoolClassMapper.fromDto(schoolClassDto);
    }

    @Override
    public SchoolClass buildWithRelatedObjects(SchoolClassDto schoolClassDto) {
        var schoolClass = build(schoolClassDto);
        schoolClass.setPeriod(periodBuilder.build(schoolClassDto.getPeriod()));
        schoolClass.setPupils(pupilBuilder.buildList(schoolClassDto.getPupils()));
        schoolClass.setTeacher(teacherBuilder.build(schoolClassDto.getTeacher()));
        schoolClass.setTimetables(timetableBuilder.buildList(schoolClassDto.getTimetables()));
        return schoolClass;
    }

}
