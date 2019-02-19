package ru.salix.ejournal.api.mapper;

import org.mapstruct.Mapper;
import ru.salix.ejournal.api.model.api.PeriodTypeDto;
import ru.salix.ejournal.api.model.dao.PeriodType;

@Mapper(componentModel = "spring")
public interface PeriodTypeMapper extends BaseMapper<PeriodType, PeriodTypeDto> {

    @FromDto
    PeriodType fromDto(PeriodTypeDto periodTypeDto);

    @ToDto
    PeriodTypeDto toDto(PeriodType periodType);

}
