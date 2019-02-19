package ru.salix.ejournal.api.builder.api;

import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.PeriodMapper;
import ru.salix.ejournal.api.model.api.PeriodDto;
import ru.salix.ejournal.api.model.dao.Period;

@Component
public class PeriodDtoBuilder extends BaseDtoBuilder<PeriodDto, Period> {

    public PeriodDtoBuilder(PeriodMapper mapper) {
        super(mapper);
    }

}
