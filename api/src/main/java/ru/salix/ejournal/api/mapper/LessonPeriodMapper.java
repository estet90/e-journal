package ru.salix.ejournal.api.mapper;

import org.mapstruct.Mapper;
import ru.salix.ejournal.api.model.api.LessonPeriodDto;
import ru.salix.ejournal.api.model.dao.LessonPeriod;

@Mapper(componentModel = "spring")
public interface LessonPeriodMapper {

    LessonPeriod lessonPeriodDtoToLessonPeriod(LessonPeriodDto lessonPeriodDto);

    LessonPeriodDto lessonPeriodToLessonPeriodDto(LessonPeriod lessonPeriod);

}
