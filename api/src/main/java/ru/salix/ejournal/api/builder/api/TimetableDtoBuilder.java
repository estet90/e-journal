package ru.salix.ejournal.api.builder.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.model.api.TimetableDto;
import ru.salix.ejournal.api.model.dao.Timetable;
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
