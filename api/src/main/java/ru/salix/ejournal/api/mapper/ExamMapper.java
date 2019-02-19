package ru.salix.ejournal.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.salix.ejournal.api.model.api.ExamDto;
import ru.salix.ejournal.api.model.api.SchoolClassDto;
import ru.salix.ejournal.api.model.api.SubjectDto;
import ru.salix.ejournal.api.model.api.TeacherDto;
import ru.salix.ejournal.api.model.dao.Exam;
import ru.salix.ejournal.api.model.dao.SchoolClass;
import ru.salix.ejournal.api.model.dao.Subject;
import ru.salix.ejournal.api.model.dao.Teacher;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ExamMapper {

    SubjectMapper subjectMapper = new SubjectMapperImpl();
    SchoolClassMapper schoolClassMapper = new SchoolClassMapperImpl();
    TeacherMapper teacherMapper = new TeacherMapperImpl();

    @Mappings({
            @Mapping(target = "subject", ignore = true),
            @Mapping(target = "schoolClass", ignore = true),
            @Mapping(target = "teachers", ignore = true)
    })
    Exam fromDto(ExamDto examDto);

    @Mappings({
            @Mapping(target = "subject", qualifiedByName = "subjectDtoToSubject"),
            @Mapping(target = "schoolClass", qualifiedByName = "schoolClassDtoToSchoolClass"),
            @Mapping(target = "teachers", qualifiedByName = "teachersDtoToTeachers")
    })
    Exam fromDtoWithRelatedObjects(ExamDto examDto);

    @Mappings({
            @Mapping(target = "subject", ignore = true),
            @Mapping(target = "schoolClass", ignore = true),
            @Mapping(target = "teachers", ignore = true)
    })
    ExamDto toDto(Exam exam);

    @Mappings({
            @Mapping(target = "subject", qualifiedByName = "subjectToSubjectDto"),
            @Mapping(target = "schoolClass", qualifiedByName = "schoolClassToSchoolClassDto"),
            @Mapping(target = "teachers", qualifiedByName = "teachersToTeachersDto")
    })
    ExamDto toDtoWithRelatedObjects(Exam exam);

    default Subject subjectDtoToSubject(SubjectDto subjectDto) {
        return subjectMapper.subjectDtoToSubject(subjectDto);
    }

    default SubjectDto subjectToSubjectDto(Subject subject) {
        return subjectMapper.subjectToSubjectDto(subject);
    }

    default SchoolClass schoolClassDtoToSchoolClass(SchoolClassDto schoolClassDto) {
        return schoolClassMapper.schoolClassDtoToSchoolClass(schoolClassDto);
    }

    default SchoolClassDto schoolClassToSchoolClassDto(SchoolClass schoolClass) {
        return schoolClassMapper.schoolClassToSchoolClassDto(schoolClass);
    }

    default List<Teacher> teachersDtoToTeachers(List<TeacherDto> teachers) {
        return teachers.stream().map(teacherMapper::teacherDtoToTeacher).collect(Collectors.toList());
    }

    default List<TeacherDto> teachersToTeachersDto(List<Teacher> teachers) {
        return teachers.stream().map(teacherMapper::teacherToTeacherDto).collect(Collectors.toList());
    }

}
