package ru.salix.ejournal.api.builder.dao;

import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.TimetableMapper;
import ru.salix.ejournal.api.model.api.TimetableDto;
import ru.salix.ejournal.api.model.dao.Timetable;

@Component
public class TimetableBuilder extends BaseDaoBuilder<Timetable, TimetableDto> {

    public TimetableBuilder(TimetableMapper mapper) {
        super(mapper);
    }

}
