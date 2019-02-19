package ru.salix.ejournal.api.builder.dao;

import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.PeriodTypeMapper;
import ru.salix.ejournal.api.model.api.PeriodTypeDto;
import ru.salix.ejournal.api.model.dao.PeriodType;

@Component
public class PeriodTypeBuilder extends BaseDaoBuilder<PeriodType, PeriodTypeDto> {

    public PeriodTypeBuilder(PeriodTypeMapper mapper) {
        super(mapper);
    }

}
