package ru.salix.ejournal.api.builder.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.TeacherMapper;
import ru.salix.ejournal.api.model.api.TeacherDto;
import ru.salix.ejournal.api.model.dao.Teacher;

@Component
@RequiredArgsConstructor
public class TeacherBuilder extends AbstractDaoBuilder<Teacher, TeacherDto> {

    private final TeacherMapper teacherMapper;

    private final SubjectBuilder subjectBuilder;
    private final SchoolClassBuilder schoolClassBuilder;
    private final TimetableBuilder timetableBuilder;
    private final ExamBuilder examBuilder;

    @Override
    public Teacher build(TeacherDto teacherDto) {
        return teacherMapper.teacherDtoToTeacher(teacherDto);
    }

    @Override
    public Teacher buildWithRelatedObjects(TeacherDto teacherDto) {
        var teacher = build(teacherDto);
        teacher.setClasses(schoolClassBuilder.buildList(teacherDto.getClasses()));
        teacher.setExams(examBuilder.buildList(teacherDto.getExams()));
        teacher.setTimetables(timetableBuilder.buildList(teacherDto.getTimetables()));
        teacher.setSubjects(subjectBuilder.buildList(teacherDto.getSubjects()));
        return teacher;
    }

}
