package ru.salix.ejournal.api.builder.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.controller.dto.PeriodTypeDto;
import ru.salix.ejournal.api.entity.PeriodType;
import ru.salix.ejournal.api.mapper.PeriodTypeMapper;

@Component
@RequiredArgsConstructor
public class PeriodTypeDtoBuilder extends AbstractDtoBuilder<PeriodTypeDto, PeriodType> {

    private final PeriodTypeMapper periodTypeMapper;

    @Override
    public PeriodTypeDto build(PeriodType periodType) {
        return periodTypeMapper.periodTypeToPeriodTypeDto(periodType);
    }

    @Override
    public PeriodTypeDto buildWithRelatedObjects(PeriodType entity) {
        return null;
    }

}
