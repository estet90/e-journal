package ru.salix.ejournal.api.builder.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.controller.dto.PeriodDto;
import ru.salix.ejournal.api.entity.Period;
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
