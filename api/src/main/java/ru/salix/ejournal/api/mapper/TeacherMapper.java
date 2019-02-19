package ru.salix.ejournal.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.salix.ejournal.api.model.api.TeacherDto;
import ru.salix.ejournal.api.model.dao.Teacher;

@Mapper(
        componentModel = "spring",
        uses = {
                SchoolClassMapper.class,
                SubjectMapper.class,
                TimetableMapper.class,
                ExamMapper.class
        }
)
public interface TeacherMapper extends BaseMapper<Teacher, TeacherDto> {

    @Mappings({
            @Mapping(target = "classes", ignore = true),
            @Mapping(target = "subjects", ignore = true),
            @Mapping(target = "timetables", ignore = true),
            @Mapping(target = "exams", ignore = true)
    })
    @FromDto
    Teacher fromDto(TeacherDto teacherDto);

    @Mappings({
            @Mapping(target = "classes", qualifiedBy = SchoolClassMapper.FromDtoList.class),
            @Mapping(target = "subjects", qualifiedBy = SubjectMapper.FromDtoList.class),
            @Mapping(target = "timetables", qualifiedBy = TimetableMapper.FromDtoList.class),
            @Mapping(target = "exams", qualifiedBy = ExamMapper.FromDtoList.class)
    })
    Teacher fromDtoWithRelatedObjects(TeacherDto teacherDto);

    @Mappings({
            @Mapping(target = "classes", ignore = true),
            @Mapping(target = "subjects", ignore = true),
            @Mapping(target = "timetables", ignore = true),
            @Mapping(target = "exams", ignore = true)
    })
    @ToDto
    TeacherDto toDto(Teacher teacher);

    @Mappings({
            @Mapping(target = "classes", qualifiedBy = SchoolClassMapper.ToDtoList.class),
            @Mapping(target = "subjects", qualifiedBy = SubjectMapper.ToDtoList.class),
            @Mapping(target = "timetables", qualifiedBy = TimetableMapper.ToDtoList.class),
            @Mapping(target = "exams", qualifiedBy = ExamMapper.ToDtoList.class)
    })
    TeacherDto toDtoWithRelatedObjects(Teacher teacher);

}
