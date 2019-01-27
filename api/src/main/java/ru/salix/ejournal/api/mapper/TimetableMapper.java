package ru.salix.ejournal.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.salix.ejournal.api.controller.dto.TimetableDto;
import ru.salix.ejournal.api.entity.Timetable;

@Mapper(componentModel = "spring")
public interface TimetableMapper {

    @Mappings({
            @Mapping(target = "subject", ignore = true),
            @Mapping(target = "schoolClass", ignore = true),
            @Mapping(target = "teacher", ignore = true),
            @Mapping(target = "lessonPeriod", ignore = true),
            @Mapping(target = "period", ignore = true)
    })
    Timetable timetableDtoToTimetable(TimetableDto timetableDto);

    @Mappings({
            @Mapping(target = "subject", ignore = true),
            @Mapping(target = "schoolClass", ignore = true),
            @Mapping(target = "teacher", ignore = true),
            @Mapping(target = "lessonPeriod", ignore = true),
            @Mapping(target = "period", ignore = true)
    })
    TimetableDto timetableToTimetableDto(Timetable timetable);

}
