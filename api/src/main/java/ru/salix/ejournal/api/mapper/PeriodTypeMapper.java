package ru.salix.ejournal.api.mapper;

import org.mapstruct.Mapper;
import ru.salix.ejournal.api.controller.dto.PeriodTypeDto;
import ru.salix.ejournal.api.entity.PeriodType;

@Mapper(componentModel = "spring")
public interface PeriodTypeMapper {

    PeriodType periodTypeDtoToPeriodType(PeriodTypeDto periodTypeDto);

    PeriodTypeDto periodTypeToPeriodTypeDto(PeriodType periodType);

}
