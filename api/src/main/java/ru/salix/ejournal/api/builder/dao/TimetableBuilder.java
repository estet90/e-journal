package ru.salix.ejournal.api.builder.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.model.api.TimetableDto;
import ru.salix.ejournal.api.model.dao.Timetable;
import ru.salix.ejournal.api.mapper.TimetableMapper;

@Component
@RequiredArgsConstructor
public class TimetableBuilder extends AbstractDaoBuilder<Timetable, TimetableDto> {

    private final TimetableMapper timetableMapper;

    private final LessonPeriodBuilder lessonPeriodBuilder;
    private final SchoolClassBuilder schoolClassBuilder;
    private final SubjectBuilder subjectBuilder;
    private final TeacherBuilder teacherBuilder;
    private final PeriodBuilder periodBuilder;

    @Override
    public Timetable build(TimetableDto timetableDto) {
        return timetableMapper.fromDto(timetableDto);
    }

    public Timetable buildWithRelatedObjects(TimetableDto timetableDto) {
        var timetable = build(timetableDto);
        timetable.setLessonPeriod(lessonPeriodBuilder.build(timetableDto.getLessonPeriod()));
        timetable.setSchoolClass(schoolClassBuilder.build(timetableDto.getSchoolClass()));
        timetable.setSubject(subjectBuilder.build(timetableDto.getSubject()));
        timetable.setTeacher(teacherBuilder.build(timetableDto.getTeacher()));
        timetable.setPeriod(periodBuilder.build(timetableDto.getPeriod()));
        return timetable;
    }

}
