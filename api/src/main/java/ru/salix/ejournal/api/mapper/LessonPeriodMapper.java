package ru.salix.ejournal.api.mapper;

import org.mapstruct.Mapper;
import ru.salix.ejournal.api.controller.dto.LessonPeriodDto;
import ru.salix.ejournal.api.entity.LessonPeriod;

@Mapper(componentModel = "spring")
public interface LessonPeriodMapper {

    LessonPeriod lessonPeriodDtoToLessonPeriod(LessonPeriodDto lessonPeriodDto);

    LessonPeriodDto lessonPeriodToLessonPeriodDto(LessonPeriod lessonPeriod);

}
