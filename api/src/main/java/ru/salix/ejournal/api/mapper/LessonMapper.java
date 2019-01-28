package ru.salix.ejournal.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.salix.ejournal.api.model.api.LessonDto;
import ru.salix.ejournal.api.model.dao.Lesson;

@Mapper(componentModel = "spring")
public interface LessonMapper {

    @Mapping(target = "timetable", ignore = true)
    Lesson lessonDtoToLesson(LessonDto lessonDto);

    @Mapping(target = "timetable", ignore = true)
    LessonDto lessonToLessonDto(Lesson lesson);

}
