package ru.salix.ejournal.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.salix.ejournal.api.model.api.ExamDto;
import ru.salix.ejournal.api.model.dao.Exam;

@Mapper(
        componentModel = "spring",
        uses = {
                SubjectMapper.class,
                SchoolClassMapper.class,
                TeacherMapper.class
        }
)
public interface ExamMapper extends BaseMapper<Exam, ExamDto> {

    @Mappings({
            @Mapping(target = "subject", ignore = true),
            @Mapping(target = "schoolClass", ignore = true),
            @Mapping(target = "teachers", ignore = true)
    })
    @FromDto
    Exam fromDto(ExamDto examDto);

    @Mappings({
            @Mapping(target = "subject", qualifiedBy = SubjectMapper.FromDto.class),
            @Mapping(target = "schoolClass", qualifiedBy = SchoolClassMapper.FromDto.class),
            @Mapping(target = "teachers", qualifiedBy = TeacherMapper.FromDtoList.class)
    })
    Exam fromDtoWithRelatedObjects(ExamDto examDto);

    @Mappings({
            @Mapping(target = "subject", ignore = true),
            @Mapping(target = "schoolClass", ignore = true),
            @Mapping(target = "teachers", ignore = true)
    })
    @ToDto
    ExamDto toDto(Exam exam);

    @Mappings({
            @Mapping(target = "subject", qualifiedBy = SubjectMapper.ToDto.class),
            @Mapping(target = "schoolClass", qualifiedBy = SchoolClassMapper.ToDto.class),
            @Mapping(target = "teachers", qualifiedBy = TeacherMapper.ToDtoList.class)
    })
    ExamDto toDtoWithRelatedObjects(Exam exam);

}
