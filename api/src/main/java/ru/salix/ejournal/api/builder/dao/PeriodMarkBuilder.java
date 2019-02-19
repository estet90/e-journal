package ru.salix.ejournal.api.builder.dao;

import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.PeriodMarkMapper;
import ru.salix.ejournal.api.model.api.PeriodMarkDto;
import ru.salix.ejournal.api.model.dao.PeriodMark;

@Component
public class PeriodMarkBuilder extends BaseDaoBuilder<PeriodMark, PeriodMarkDto> {

    public PeriodMarkBuilder(PeriodMarkMapper mapper) {
        super(mapper);
    }

}
