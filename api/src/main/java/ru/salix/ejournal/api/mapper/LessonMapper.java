package ru.salix.ejournal.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.salix.ejournal.api.model.api.LessonDto;
import ru.salix.ejournal.api.model.dao.Lesson;

@Mapper(componentModel = "spring", uses = TimetableMapper.class)
public interface LessonMapper extends BaseMapper<Lesson, LessonDto> {

    @Mapping(target = "timetable", ignore = true)
    @FromDto
    Lesson fromDto(LessonDto lessonDto);

    @Mapping(target = "timetable", qualifiedBy = TimetableMapper.FromDto.class)
    Lesson fromDtoWithRelatedObjects(LessonDto lessonDto);

    @Mapping(target = "timetable", ignore = true)
    @ToDto
    LessonDto toDto(Lesson lesson);

    @Mapping(target = "timetable", qualifiedBy = TimetableMapper.ToDto.class)
    LessonDto toDtoWithRelatedObjects(Lesson lesson);

}
