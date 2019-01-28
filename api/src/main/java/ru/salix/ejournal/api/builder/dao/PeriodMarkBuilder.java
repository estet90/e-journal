package ru.salix.ejournal.api.builder.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.model.api.PeriodMarkDto;
import ru.salix.ejournal.api.model.dao.PeriodMark;
import ru.salix.ejournal.api.mapper.PeriodMarkMapper;

@Component
@RequiredArgsConstructor
public class PeriodMarkBuilder extends AbstractDaoBuilder<PeriodMark, PeriodMarkDto> {

    private final PeriodMarkMapper periodMarkMapper;

    @Override
    public PeriodMark build(PeriodMarkDto periodMarkDto) {
        return periodMarkMapper.periodMarkDtoToPeriodMark(periodMarkDto);
    }

}
