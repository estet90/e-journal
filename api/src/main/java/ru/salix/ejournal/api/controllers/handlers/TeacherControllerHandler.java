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
import ru.salix.ejournal.api.entities.SchoolClass;
import ru.salix.ejournal.api.entities.Subject;
import ru.salix.ejournal.api.entities.Teacher;
import ru.salix.ejournal.api.dao.services.SchoolClassService;
import ru.salix.ejournal.api.dao.services.SubjectService;
import ru.salix.ejournal.api.dao.services.TeacherService;

import java.util.List;

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
        List<Teacher> teachers = teacherService.findAll();
        return teachers
                .stream()
                .map(teacher -> teacherDto(teacher, withSubjects, withClasses))
                .collect(toList());
    }

    public TeacherDto teacherById(long id, boolean withSubjects, boolean withClasses) {
        Teacher teacher = teacherService.findById(id);
        return teacherDto(teacher, withSubjects, withClasses);
    }

    public List<TeacherDto> filter(TeacherFilterDto filter, boolean withSubjects, boolean withClasses) {
        return null;
    }

    private TeacherDto teacherDto(Teacher teacher, boolean withSubjects, boolean withClasses) {
        List<SubjectDto> subjectDtoList = null;
        if (withSubjects) {
            List<Subject> subjects = subjectService.findAllByTeachersIs(teacher);
            subjectDtoList = subjectDtoBuilder.dtoList(subjects);
        }
        List<SchoolClassDto> schoolClassDtoList = null;
        if (withClasses) {
            List<SchoolClass> classes = schoolClassService.findAllByTeacher(teacher);
            schoolClassDtoList = schoolClassDtoBuilder.dtoList(classes);
        }
        return teacherDtoBuilder.build(teacher, subjectDtoList, schoolClassDtoList);
    }

}
