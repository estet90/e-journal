package ru.salix.ejournal.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.salix.ejournal.api.model.api.PeriodDto;
import ru.salix.ejournal.api.model.dao.Period;

@Mapper(componentModel = "spring")
public interface PeriodMapper {

    @Mapping(target = "periodType", ignore = true)
    Period periodDtoToPeriod(PeriodDto periodDto);

    @Mapping(target = "periodType", ignore = true)
    PeriodDto periodToPeriodDto(Period period);

}
