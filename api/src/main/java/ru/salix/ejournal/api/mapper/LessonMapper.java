package ru.salix.ejournal.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.salix.ejournal.api.controller.dto.LessonDto;
import ru.salix.ejournal.api.entity.Lesson;

@Mapper(componentModel = "spring")
public interface LessonMapper {

    @Mapping(target = "timetable", ignore = true)
    Lesson lessonDtoToLesson(LessonDto lessonDto);

    @Mapping(target = "timetable", ignore = true)
    LessonDto lessonToLessonDto(Lesson lesson);

}
