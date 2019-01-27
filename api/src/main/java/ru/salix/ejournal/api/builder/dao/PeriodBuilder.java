package ru.salix.ejournal.api.builder.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.controller.dto.PeriodDto;
import ru.salix.ejournal.api.entity.Period;
import ru.salix.ejournal.api.mapper.PeriodMapper;

@Component
@RequiredArgsConstructor
public class PeriodBuilder extends AbstractDaoBuilder<Period, PeriodDto> {

    private final PeriodMapper periodMapper;

    @Override
    public Period build(PeriodDto periodDto) {
        return periodMapper.periodDtoToPeriod(periodDto);
    }

}
