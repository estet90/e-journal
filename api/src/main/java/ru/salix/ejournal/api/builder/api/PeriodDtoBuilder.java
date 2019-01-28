package ru.salix.ejournal.api.builder.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.model.api.PeriodDto;
import ru.salix.ejournal.api.model.dao.Period;
import ru.salix.ejournal.api.mapper.PeriodMapper;

@Component
@RequiredArgsConstructor
public class PeriodDtoBuilder extends AbstractDtoBuilder<PeriodDto, Period> {

    private final PeriodMapper periodMapper;

    @Override
    public PeriodDto build(Period period) {
        return periodMapper.periodToPeriodDto(period);
    }

    @Override
    public PeriodDto buildWithRelatedObjects(Period entity) {
        return null;
    }

}
