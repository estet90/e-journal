package ru.salix.ejournal.api.builder.api;

import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.PeriodMarkMapper;
import ru.salix.ejournal.api.model.api.PeriodMarkDto;
import ru.salix.ejournal.api.model.dao.PeriodMark;

@Component
public class PeriodMarkDtoBuilder extends BaseDtoBuilder<PeriodMarkDto, PeriodMark> {

    public PeriodMarkDtoBuilder(PeriodMarkMapper mapper) {
        super(mapper);
    }

}
