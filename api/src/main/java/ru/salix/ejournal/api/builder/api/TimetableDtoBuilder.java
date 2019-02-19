package ru.salix.ejournal.api.builder.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.TimetableMapper;
import ru.salix.ejournal.api.model.api.TimetableDto;
import ru.salix.ejournal.api.model.dao.Timetable;

@Component
@RequiredArgsConstructor
public class TimetableDtoBuilder extends AbstractDtoBuilder<TimetableDto, Timetable> {

    private final TimetableMapper timetableMapper;

    private final LessonPeriodDtoBuilder lessonPeriodDtoBuilder;
    private final SchoolClassDtoBuilder schoolClassDtoBuilder;
    private final SubjectDtoBuilder subjectDtoBuilder;
    private final TeacherDtoBuilder teacherDtoBuilder;
    private final PeriodDtoBuilder periodDtoBuilder;

    @Override
    public TimetableDto build(Timetable timetable) {
        return timetableMapper.toDto(timetable);
    }

    @Override
    public TimetableDto buildWithRelatedObjects(Timetable timetable) {
        var timetableDto = build(timetable);
        timetableDto.setLessonPeriod(lessonPeriodDtoBuilder.build(timetable.getLessonPeriod()));
        timetableDto.setSchoolClass(schoolClassDtoBuilder.build(timetable.getSchoolClass()));
        timetableDto.setSubject(subjectDtoBuilder.build(timetable.getSubject()));
        timetableDto.setTeacher(teacherDtoBuilder.build(timetable.getTeacher()));
        timetableDto.setPeriod(periodDtoBuilder.build(timetable.getPeriod()));
        return timetableDto;
    }

}
