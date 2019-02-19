package ru.salix.ejournal.api.builder.api;

import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.TimetableMapper;
import ru.salix.ejournal.api.model.api.TimetableDto;
import ru.salix.ejournal.api.model.dao.Timetable;

@Component
public class TimetableDtoBuilder extends BaseDtoBuilder<TimetableDto, Timetable> {

    public TimetableDtoBuilder(TimetableMapper mapper) {
        super(mapper);
    }

}
