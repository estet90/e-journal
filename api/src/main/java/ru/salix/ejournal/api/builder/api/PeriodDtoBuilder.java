package ru.salix.ejournal.api.builder.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.PeriodMapper;
import ru.salix.ejournal.api.model.api.PeriodDto;
import ru.salix.ejournal.api.model.dao.Period;

@Component
@RequiredArgsConstructor
public class PeriodDtoBuilder extends AbstractDtoBuilder<PeriodDto, Period> {

    private final PeriodMapper periodMapper;

    private final PeriodTypeDtoBuilder periodTypeDtoBuilder;
    private final TimetableDtoBuilder timetableDtoBuilder;

    @Override
    public PeriodDto build(Period period) {
        return periodMapper.periodToPeriodDto(period);
    }

    @Override
    public PeriodDto buildWithRelatedObjects(Period period) {
        var periodDto = build(period);
        periodDto.setPeriodType(periodTypeDtoBuilder.build(period.getPeriodType()));
        periodDto.setTimetables(timetableDtoBuilder.buildList(period.getTimetables()));
        return periodDto;
    }

}
