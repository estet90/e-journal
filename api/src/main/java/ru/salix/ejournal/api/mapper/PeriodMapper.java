package ru.salix.ejournal.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.salix.ejournal.api.model.api.PeriodDto;
import ru.salix.ejournal.api.model.dao.Period;

@Mapper(componentModel = "spring")
public interface PeriodMapper {

    @Mappings({
            @Mapping(target = "periodType", ignore = true),
            @Mapping(target = "timetables", ignore = true)
    })
    Period periodDtoToPeriod(PeriodDto periodDto);

    @Mappings({
            @Mapping(target = "periodType", ignore = true),
            @Mapping(target = "timetables", ignore = true)
    })
    PeriodDto periodToPeriodDto(Period period);

}
