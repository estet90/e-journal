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

    private final PeriodTypeBuilder periodTypeBuilder;
    private final TimetableBuilder timetableBuilder;

    @Override
    public Period build(PeriodDto periodDto) {
        return periodMapper.fromDto(periodDto);
    }

    @Override
    public Period buildWithRelatedObjects(PeriodDto periodDto) {
        var period = build(periodDto);
        period.setPeriodType(periodTypeBuilder.build(periodDto.getPeriodType()));
        period.setTimetables(timetableBuilder.buildList(periodDto.getTimetables()));
        return period;
    }

}
