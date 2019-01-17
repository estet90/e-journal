package ru.salix.ejournal.api.controller.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.controller.builder.SchoolClassDtoBuilder;
import ru.salix.ejournal.api.controller.builder.SubjectDtoBuilder;
import ru.salix.ejournal.api.controller.builder.TeacherDtoBuilder;
import ru.salix.ejournal.api.controller.dto.SchoolClassDto;
import ru.salix.ejournal.api.controller.dto.SubjectDto;
import ru.salix.ejournal.api.controller.dto.TeacherDto;
import ru.salix.ejournal.api.controller.dto.TeacherFilterDto;
import ru.salix.ejournal.api.dao.service.SchoolClassService;
import ru.salix.ejournal.api.dao.service.SubjectService;
import ru.salix.ejournal.api.dao.service.SubjectTeacherService;
import ru.salix.ejournal.api.dao.service.TeacherService;
import ru.salix.ejournal.api.entity.Subject;
import ru.salix.ejournal.api.entity.Teacher;
import ru.salix.ejournal.api.mapper.TeacherMapper;
import ru.salix.ejournal.error.exception.InvocationException;

import java.util.List;
import java.util.Map;

import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;
import static ru.salix.ejournal.api.error.exception.InvocationExceptionCode.NOT_FOUND_IN_DB_EXCEPTION;
import static ru.salix.ejournal.api.error.operation.ModuleOperationCode.resolve;
import static ru.salix.ejournal.api.helper.OperationWrapper.wrap;
import static ru.salix.ejournal.error.exception.ExceptionFactory.newInvocationException;

@Service
@RequiredArgsConstructor
public class TeacherControllerHandler {

    private final TeacherService teacherService;
    private final TeacherDtoBuilder teacherDtoBuilder;

    private final SubjectService subjectService;
    private final SubjectDtoBuilder subjectDtoBuilder;

    private final SchoolClassService schoolClassService;
    private final SchoolClassDtoBuilder schoolClassDtoBuilder;

    private final TeacherMapper teacherMapper;

    private final SubjectTeacherService subjectTeacherService;

    public List<TeacherDto> findTeachers() {
        return wrap(() -> {
            var teachers = teacherService.findAll();
            return teacherDtoList(teachers);
        });
    }

    public TeacherDto findTeacherById(long id) {
        return wrap(() -> {
            var teacher = teacherService.findById(id);
            return teacherDtoBuilder.build(teacher);
        });
    }

    public List<TeacherDto> filter(TeacherFilterDto filter) {
        return wrap(() -> {
            var teachers = teacherService.filter(filter);
            return teacherDtoList(teachers);
        });
    }

    public Long createTeacher(TeacherDto teacherDto) {
        return wrap(() -> {
            var teacher = teacherMapper.teacherDtoToTeacher(teacherDto);
            teacher = teacherService.save(teacher);
            return teacher.getId();
        });
    }

    public Long updateTeacher(TeacherDto teacherDto, Long id) {
        return wrap(() -> {
            var teacher = teacherService.findById(id);
            return ofNullable(teacher)
                    .map(updatedTeacher -> {
                        updatedTeacher = teacherMapper.teacherDtoToTeacher(teacherDto);
                        updatedTeacher.setId(id);
                        teacherService.save(updatedTeacher);
                        return id;
                    })
                    .orElseThrow(() -> notFoundInDbException(String.format("Не найден учитель по id = %s", id)));
        });
    }

    public Long deleteTeacher(Long id) {
        return wrap(() -> {
            teacherService.deleteById(id);
            return 1L;
        });
    }

    public List<SubjectDto> subjectsByTeacherId(Long id) {
        return wrap(() -> {
            var subjects = subjectService.findAllByTeacherId(id);
            return subjectDtoBuilder.dtoList(subjects);
        });
    }

    public long addSubjectToTeacher(Long idTeacher, Long idSubject) {
        return wrap(() -> {
            var teacherSubjectEntry = teacherSubjectEntry(idTeacher, idSubject);
            subjectTeacherService.save(teacherSubjectEntry.getKey(), teacherSubjectEntry.getValue());
            return 1L;
        });
    }

    public long deleteSubjectFromTeacher(Long idTeacher, Long idSubject) {
        return wrap(() -> {
            var teacherSubjectEntry = teacherSubjectEntry(idTeacher, idSubject);
            return subjectTeacherService.delete(teacherSubjectEntry.getKey(), teacherSubjectEntry.getValue());
        });
    }

    public List<SchoolClassDto> classesByTeacherId(Long id) {
        return wrap(() -> {
            var classes = schoolClassService.findAllByTeacherId(id);
            return schoolClassDtoBuilder.dtoList(classes);
        });
    }

    private Map.Entry<Teacher, Subject> teacherSubjectEntry(Long idTeacher, Long idSubject) {
        var teacher = ofNullable(teacherService.findById(idTeacher))
                .orElseThrow(() -> notFoundInDbException(String.format("Не найден учитель по id = %s", idTeacher)));
        var subject = ofNullable(subjectService.findById(idSubject))
                .orElseThrow(() -> notFoundInDbException(String.format("Не найден предмет по id = %s", idSubject)));
        return Map.entry(teacher, subject);
    }

    private InvocationException notFoundInDbException(String message) {
        return newInvocationException(resolve(), NOT_FOUND_IN_DB_EXCEPTION, message);
    }

    private List<TeacherDto> teacherDtoList(List<Teacher> teachers) {
        return teachers
                .stream()
                .map(teacherDtoBuilder::build)
                .collect(toList());
    }

}
