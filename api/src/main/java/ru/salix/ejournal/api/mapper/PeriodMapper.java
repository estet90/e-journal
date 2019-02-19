package ru.salix.ejournal.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.salix.ejournal.api.model.api.PeriodDto;
import ru.salix.ejournal.api.model.dao.Period;

@Mapper(
        componentModel = "spring",
        uses = {
                PeriodTypeMapper.class,
                TimetableMapper.class
        }
)
public interface PeriodMapper extends BaseMapper<Period, PeriodDto> {

    @Mappings({
            @Mapping(target = "periodType", ignore = true),
            @Mapping(target = "timetables", ignore = true)
    })
    @FromDto
    Period fromDto(PeriodDto periodDto);

    @Mappings({
            @Mapping(target = "periodType", qualifiedBy = PeriodTypeMapper.FromDto.class),
            @Mapping(target = "timetables", qualifiedBy = TimetableMapper.FromDtoList.class)
    })
    Period fromDtoWithRelatedObjects(PeriodDto periodDto);

    @Mappings({
            @Mapping(target = "periodType", ignore = true),
            @Mapping(target = "timetables", ignore = true)
    })
    @ToDto
    PeriodDto toDto(Period period);

    @Mappings({
            @Mapping(target = "periodType", qualifiedBy = PeriodTypeMapper.ToDto.class),
            @Mapping(target = "timetables", qualifiedBy = TimetableMapper.ToDtoList.class)
    })
    PeriodDto toDtoWithRelatedObjects(Period period);

}
