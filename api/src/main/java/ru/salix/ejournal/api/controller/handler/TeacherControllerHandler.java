package ru.salix.ejournal.api.controller.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.builder.dao.TeacherBuilder;
import ru.salix.ejournal.api.builder.dto.SchoolClassDtoBuilder;
import ru.salix.ejournal.api.builder.dto.SubjectDtoBuilder;
import ru.salix.ejournal.api.builder.dto.TeacherDtoBuilder;
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

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static java.util.Optional.ofNullable;
import static ru.salix.ejournal.api.helper.ExceptionHelper.notFoundInDbException;
import static ru.salix.ejournal.api.helper.OperationWrapper.wrap;

@Service
@RequiredArgsConstructor
public class TeacherControllerHandler {

    private final TeacherService teacherService;
    private final TeacherDtoBuilder teacherDtoBuilder;
    private final TeacherBuilder teacherBuilder;

    private final SubjectService subjectService;
    private final SubjectDtoBuilder subjectDtoBuilder;

    private final SchoolClassService schoolClassService;
    private final SchoolClassDtoBuilder schoolClassDtoBuilder;

    private final SubjectTeacherService subjectTeacherService;

    public List<TeacherDto> findTeachers() {
        return teacherDtoList(teacherService::findAll);
    }

    public TeacherDto findTeacherById(long id) {
        return wrap(() -> {
            var teacher = teacherService.findById(id);
            return teacherDtoBuilder.build(teacher);
        });
    }

    public List<TeacherDto> filter(TeacherFilterDto filter) {
        return teacherDtoList(() -> teacherService.filter(filter));
    }

    public Long createTeacher(TeacherDto teacherDto) {
        return wrap(() -> teacherService.saveAndReturnId(teacherBuilder.build(teacherDto)));
    }

    public Long updateTeacher(TeacherDto teacherDto, Long id) {
        return wrap(() -> ofNullable(teacherService.findById(id))
                .map(teacher -> teacherService.saveAndReturnId(teacherBuilder.build(teacherDto, id)))
                .orElseThrow(() -> notFoundInDbException(String.format("Не найден учитель по id = %s", id))));
    }

    public Long deleteTeacher(Long id) {
        return wrap(() -> {
            teacherService.deleteById(id);
            return 1L;
        });
    }

    public List<SubjectDto> subjectsByTeacherId(Long id) {
        return wrap(() -> subjectDtoBuilder.buildList(subjectService.findAllByTeacherId(id)));
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
        return wrap(() -> schoolClassDtoBuilder.buildList(schoolClassService.findAllByTeacherId(id)));
    }

    private Map.Entry<Teacher, Subject> teacherSubjectEntry(Long idTeacher, Long idSubject) {
        var teacher = ofNullable(teacherService.findById(idTeacher))
                .orElseThrow(() -> notFoundInDbException(String.format("Не найден учитель по id = %s", idTeacher)));
        var subject = ofNullable(subjectService.findById(idSubject))
                .orElseThrow(() -> notFoundInDbException(String.format("Не найден предмет по id = %s", idSubject)));
        return Map.entry(teacher, subject);
    }

    private List<TeacherDto> teacherDtoList(Supplier<List<Teacher>> supplier) {
        return wrap(() -> teacherDtoBuilder.buildList(supplier.get()));
    }

}
