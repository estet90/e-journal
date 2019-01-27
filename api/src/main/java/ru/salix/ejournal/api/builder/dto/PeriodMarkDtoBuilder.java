package ru.salix.ejournal.api.builder.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.controller.dto.PeriodMarkDto;
import ru.salix.ejournal.api.entity.PeriodMark;
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
