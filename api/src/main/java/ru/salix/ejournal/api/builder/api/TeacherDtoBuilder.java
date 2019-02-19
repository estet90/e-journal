package ru.salix.ejournal.api.builder.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.TeacherMapper;
import ru.salix.ejournal.api.model.api.TeacherDto;
import ru.salix.ejournal.api.model.dao.Teacher;

@Component
@RequiredArgsConstructor
public class TeacherDtoBuilder extends AbstractDtoBuilder<TeacherDto, Teacher> {

    private final TeacherMapper teacherMapper;

    private final SubjectDtoBuilder subjectDtoBuilder;
    private final SchoolClassDtoBuilder schoolClassDtoBuilder;
    private final TimetableDtoBuilder timetableDtoBuilder;
    private final ExamDtoBuilder examDtoBuilder;

    @Override
    public TeacherDto build(Teacher teacher) {
        return teacherMapper.teacherToTeacherDto(teacher);
    }

    @Override
    public TeacherDto buildWithRelatedObjects(Teacher teacher) {
        var teacherDto = build(teacher);
        teacherDto.setClasses(schoolClassDtoBuilder.buildList(teacher.getClasses()));
        teacherDto.setExams(examDtoBuilder.buildList(teacher.getExams()));
        teacherDto.setTimetables(timetableDtoBuilder.buildList(teacher.getTimetables()));
        teacherDto.setSubjects(subjectDtoBuilder.buildList(teacher.getSubjects()));
        return teacherDto;
    }

}
