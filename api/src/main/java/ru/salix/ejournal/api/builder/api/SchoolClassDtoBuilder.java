package ru.salix.ejournal.api.builder.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.SchoolClassMapper;
import ru.salix.ejournal.api.model.api.SchoolClassDto;
import ru.salix.ejournal.api.model.dao.SchoolClass;

@Component
@RequiredArgsConstructor
public class SchoolClassDtoBuilder extends AbstractDtoBuilder<SchoolClassDto, SchoolClass> {

    private final SchoolClassMapper schoolClassMapper;

    private final PeriodDtoBuilder periodDtoBuilder;
    private final PupilDtoBuilder pupilDtoBuilder;
    private final TeacherDtoBuilder teacherDtoBuilder;
    private final TimetableDtoBuilder timetableDtoBuilder;

    @Override
    public SchoolClassDto build(SchoolClass schoolClass) {
        return schoolClassMapper.schoolClassToSchoolClassDto(schoolClass);
    }

    @Override
    public SchoolClassDto buildWithRelatedObjects(SchoolClass schoolClass) {
        var schoolClassDto = build(schoolClass);
        schoolClassDto.setPeriod(periodDtoBuilder.build(schoolClass.getPeriod()));
        schoolClassDto.setPupils(pupilDtoBuilder.buildList(schoolClass.getPupils()));
        schoolClassDto.setTeacher(teacherDtoBuilder.build(schoolClass.getTeacher()));
        schoolClassDto.setTimetables(timetableDtoBuilder.buildList(schoolClass.getTimetables()));
        return schoolClassDto;
    }

}
