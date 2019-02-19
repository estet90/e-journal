package ru.salix.ejournal.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.salix.ejournal.api.model.api.TeacherDto;
import ru.salix.ejournal.api.model.dao.Teacher;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    @Mappings({
            @Mapping(target = "classes", ignore = true),
            @Mapping(target = "subjects", ignore = true),
            @Mapping(target = "timetables", ignore = true),
            @Mapping(target = "exams", ignore = true)
    })
    Teacher teacherDtoToTeacher(TeacherDto teacherDto);

    @Mappings({
            @Mapping(target = "classes", ignore = true),
            @Mapping(target = "subjects", ignore = true),
            @Mapping(target = "timetables", ignore = true),
            @Mapping(target = "exams", ignore = true)
    })
    TeacherDto teacherToTeacherDto(Teacher teacher);

}
