package ru.salix.ejournal.api.builder.dao;

import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.PeriodMapper;
import ru.salix.ejournal.api.model.api.PeriodDto;
import ru.salix.ejournal.api.model.dao.Period;

@Component
public class PeriodBuilder extends BaseDaoBuilder<Period, PeriodDto> {

    public PeriodBuilder(PeriodMapper mapper) {
        super(mapper);
    }

}
