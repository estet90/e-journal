package ru.salix.ejournal.api.builder.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.model.api.PeriodDto;
import ru.salix.ejournal.api.model.dao.Period;
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
