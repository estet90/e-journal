package ru.salix.ejournal.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.salix.ejournal.api.controller.dto.PeriodDto;
import ru.salix.ejournal.api.entity.Period;

@Mapper(componentModel = "spring")
public interface PeriodMapper {

    @Mapping(target = "periodType", ignore = true)
    Period periodDtoToPeriod(PeriodDto periodDto);

    @Mapping(target = "periodType", ignore = true)
    PeriodDto periodToPeriodDto(Period period);

}
