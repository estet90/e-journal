package ru.salix.ejournal.api.builder.api;

import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.PeriodTypeMapper;
import ru.salix.ejournal.api.model.api.PeriodTypeDto;
import ru.salix.ejournal.api.model.dao.PeriodType;

@Component
public class PeriodTypeDtoBuilder extends BaseDtoBuilder<PeriodTypeDto, PeriodType> {

    public PeriodTypeDtoBuilder(PeriodTypeMapper mapper) {
        super(mapper);
    }

}
