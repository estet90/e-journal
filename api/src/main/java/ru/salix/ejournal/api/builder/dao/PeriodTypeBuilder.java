package ru.salix.ejournal.api.builder.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.PeriodTypeMapper;
import ru.salix.ejournal.api.model.api.PeriodTypeDto;
import ru.salix.ejournal.api.model.dao.PeriodType;

@Component
@RequiredArgsConstructor
public class PeriodTypeBuilder extends AbstractDaoBuilder<PeriodType, PeriodTypeDto> {

    private final PeriodTypeMapper periodTypeMapper;

    @Override
    public PeriodType build(PeriodTypeDto periodTypeDto) {
        return periodTypeMapper.periodTypeDtoToPeriodType(periodTypeDto);
    }

    @Override
    public PeriodType buildWithRelatedObjects(PeriodTypeDto periodTypeDto) {
        return build(periodTypeDto);
    }

}
