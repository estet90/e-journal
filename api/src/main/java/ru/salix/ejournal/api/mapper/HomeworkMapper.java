package ru.salix.ejournal.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.salix.ejournal.api.model.api.HomeworkDto;
import ru.salix.ejournal.api.model.dao.Homework;

@Mapper(componentModel = "spring", uses = LessonMapper.class)
public interface HomeworkMapper extends BaseMapper<Homework, HomeworkDto> {

    @Mappings({
            @Mapping(target = "lessonReceive", ignore = true),
            @Mapping(target = "lessonComplete", ignore = true)
    })
    @FromDto
    Homework fromDto(HomeworkDto homeworkDto);

    @Mappings({
            @Mapping(target = "lessonReceive", qualifiedBy = LessonMapper.FromDto.class),
            @Mapping(target = "lessonComplete", qualifiedBy = LessonMapper.FromDto.class)
    })
    Homework fromDtoWithRelatedObjects(HomeworkDto homeworkDto);

    @Mappings({
            @Mapping(target = "lessonReceive", ignore = true),
            @Mapping(target = "lessonComplete", ignore = true)
    })
    @ToDto
    HomeworkDto toDto(Homework homework);

    @Mappings({
            @Mapping(target = "lessonReceive", qualifiedBy = LessonMapper.ToDto.class),
            @Mapping(target = "lessonComplete", qualifiedBy = LessonMapper.ToDto.class)
    })
    HomeworkDto toDtoWithRelatedObjects(Homework homework);

}
