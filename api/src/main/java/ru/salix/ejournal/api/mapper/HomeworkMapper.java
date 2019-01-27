package ru.salix.ejournal.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.salix.ejournal.api.controller.dto.HomeworkDto;
import ru.salix.ejournal.api.entity.Homework;

@Mapper(componentModel = "spring")
public interface HomeworkMapper {

    @Mappings({
            @Mapping(target = "lessonReceive", ignore = true),
            @Mapping(target = "lessonComplete", ignore = true)
    })
    Homework homeworkDtoToHomework(HomeworkDto homeworkDto);

    @Mappings({
            @Mapping(target = "lessonReceive", ignore = true),
            @Mapping(target = "lessonComplete", ignore = true)
    })
    HomeworkDto homeworkToHomeworkDto(Homework homework);

}
