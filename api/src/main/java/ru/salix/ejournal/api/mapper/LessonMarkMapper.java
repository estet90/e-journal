package ru.salix.ejournal.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.salix.ejournal.api.controller.dto.LessonMarkDto;
import ru.salix.ejournal.api.entity.LessonMark;

@Mapper(componentModel = "spring")
public interface LessonMarkMapper {

    @Mappings({
            @Mapping(target = "lesson", ignore = true),
            @Mapping(target = "homework", ignore = true),
            @Mapping(target = "test", ignore = true),
            @Mapping(target = "pupil", ignore = true)
    })
    LessonMark lessonMarkDtoToLessonMark(LessonMarkDto lessonMarkDto);

    @Mappings({
            @Mapping(target = "lesson", ignore = true),
            @Mapping(target = "homework", ignore = true),
            @Mapping(target = "test", ignore = true),
            @Mapping(target = "pupil", ignore = true)
    })
    LessonMarkDto lessonMarkToLessonMarkDto(LessonMark lessonMark);

}
