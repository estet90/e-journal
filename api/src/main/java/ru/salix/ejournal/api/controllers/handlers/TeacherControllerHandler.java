package ru.salix.ejournal.api.controllers.handlers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.controllers.builders.SchoolClassDtoBuilder;
import ru.salix.ejournal.api.controllers.builders.SubjectDtoBuilder;
import ru.salix.ejournal.api.controllers.builders.TeacherDtoBuilder;
import ru.salix.ejournal.api.controllers.dto.SchoolClassDto;
import ru.salix.ejournal.api.controllers.dto.SubjectDto;
import ru.salix.ejournal.api.controllers.dto.TeacherDto;
import ru.salix.ejournal.api.controllers.dto.TeacherFilterDto;
import ru.salix.ejournal.api.dao.services.SchoolClassService;
import ru.salix.ejournal.api.dao.services.SubjectService;
import ru.salix.ejournal.api.dao.services.TeacherService;
import ru.salix.ejournal.api.entities.Teacher;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class TeacherControllerHandler {

    private final TeacherService teacherService;
    private final TeacherDtoBuilder teacherDtoBuilder;

    private final SubjectService subjectService;
    private final SubjectDtoBuilder subjectDtoBuilder;

    private final SchoolClassService schoolClassService;
    private final SchoolClassDtoBuilder schoolClassDtoBuilder;

    public List<TeacherDto> teachers(boolean withSubjects, boolean withClasses) {
        var teachers = teacherService.findAll();
        return teacherDtoList(teachers, withSubjects, withClasses);
    }

    public TeacherDto teacherById(long id, boolean withSubjects, boolean withClasses) {
        var teacher = teacherService.findById(id);
        return teacherDto(teacher, withSubjects, withClasses);
    }

    public List<TeacherDto> filter(TeacherFilterDto filter, boolean withSubjects, boolean withClasses) {
        var teachers = teacherService.filter(filter);
        return teacherDtoList(teachers, withSubjects, withClasses);
    }

    private List<TeacherDto> teacherDtoList(List<Teacher> teachers, boolean withSubjects, boolean withClasses) {
        return teachers
                .stream()
                .map(teacher -> teacherDto(teacher, withSubjects, withClasses))
                .collect(toList());
    }

    private TeacherDto teacherDto(Teacher teacher, boolean withSubjects, boolean withClasses) {
        List<SubjectDto> subjectDtoList = withSubjects ? subjectDtoList(teacher) : emptyList();
        List<SchoolClassDto> schoolClassDtoList = withClasses ? schoolClassDtoList(teacher) : emptyList();
        return teacherDtoBuilder.build(teacher, subjectDtoList, schoolClassDtoList);
    }

    private List<SubjectDto> subjectDtoList(Teacher teacher) {
        var subjects = subjectService.findAllByTeachersIs(teacher);
        return subjectDtoBuilder.dtoList(subjects);
    }

    private List<SchoolClassDto> schoolClassDtoList(Teacher teacher) {
        var classes = schoolClassService.findAllByTeacher(teacher);
        return schoolClassDtoBuilder.dtoList(classes);
    }

}
