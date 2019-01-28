package ru.salix.ejournal.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.salix.ejournal.api.model.api.PeriodMarkDto;
import ru.salix.ejournal.api.model.dao.PeriodMark;

@Mapper(componentModel = "spring")
public interface PeriodMarkMapper {

    @Mappings({
            @Mapping(target = "subject", ignore = true),
            @Mapping(target = "period", ignore = true),
            @Mapping(target = "pupil", ignore = true)
    })
    PeriodMark periodMarkDtoToPeriodMark(PeriodMarkDto periodMarkDto);

    @Mappings({
            @Mapping(target = "subject", ignore = true),
            @Mapping(target = "period", ignore = true),
            @Mapping(target = "pupil", ignore = true)
    })
    PeriodMarkDto periodMarkToPeriodMarkDto(PeriodMark periodMark);

}