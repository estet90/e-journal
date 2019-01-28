package ru.salix.ejournal.api.builder.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.model.api.PeriodMarkDto;
import ru.salix.ejournal.api.model.dao.PeriodMark;
import ru.salix.ejournal.api.mapper.PeriodMarkMapper;

@Component
@RequiredArgsConstructor
public class PeriodMarkDtoBuilder extends AbstractDtoBuilder<PeriodMarkDto, PeriodMark> {

    private final PeriodMarkMapper periodMarkMapper;

    @Override
    public PeriodMarkDto build(PeriodMark periodMark) {
        return periodMarkMapper.periodMarkToPeriodMarkDto(periodMark);
    }

    @Override
    public PeriodMarkDto buildWithRelatedObjects(PeriodMark entity) {
        return null;
    }

}
