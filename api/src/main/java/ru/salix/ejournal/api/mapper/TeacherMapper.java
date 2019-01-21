package ru.salix.ejournal.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.salix.ejournal.api.controller.dto.TeacherDto;
import ru.salix.ejournal.api.entity.Teacher;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    @Mappings({
            @Mapping(target = "classes", ignore = true),
            @Mapping(target = "subjects", ignore = true),
            @Mapping(target = "timetables", ignore = true),
    })
    Teacher teacherDtoToTeacher(TeacherDto teacherDto);

    TeacherDto teacherToTeacherDto(Teacher teacher);

}
