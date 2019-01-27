package ru.salix.ejournal.api.builder.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.controller.dto.TimetableDto;
import ru.salix.ejournal.api.entity.Timetable;
import ru.salix.ejournal.api.mapper.TimetableMapper;

@Component
@RequiredArgsConstructor
public class TimetableDtoBuilder extends AbstractDtoBuilder<TimetableDto, Timetable>{

    private final TimetableMapper timetableMapper;

    @Override
    public TimetableDto build(Timetable timetable) {
        return timetableMapper.timetableToTimetableDto(timetable);
    }

    @Override
    public TimetableDto buildWithRelatedObjects(Timetable entity) {
        return null;
    }

}
