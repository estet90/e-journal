package ru.salix.ejournal.api.builder.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.controller.dto.PeriodTypeDto;
import ru.salix.ejournal.api.entity.PeriodType;
import ru.salix.ejournal.api.mapper.PeriodTypeMapper;

@Component
@RequiredArgsConstructor
public class PeriodTypeBuilder extends AbstractDaoBuilder<PeriodType, PeriodTypeDto> {

    private final PeriodTypeMapper periodTypeMapper;

    @Override
    public PeriodType build(PeriodTypeDto periodTypeDto) {
        return periodTypeMapper.periodTypeDtoToPeriodType(periodTypeDto);
    }

}
