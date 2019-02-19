package ru.salix.ejournal.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.salix.ejournal.api.model.api.PeriodMarkDto;
import ru.salix.ejournal.api.model.dao.PeriodMark;

@Mapper(
        componentModel = "spring",
        uses = {
                SubjectMapper.class,
                PeriodMapper.class,
                PupilMapper.class
        }
)
public interface PeriodMarkMapper extends BaseMapper<PeriodMark, PeriodMarkDto> {

    @Mappings({
            @Mapping(target = "subject", ignore = true),
            @Mapping(target = "period", ignore = true),
            @Mapping(target = "pupil", ignore = true)
    })
    PeriodMark fromDto(PeriodMarkDto periodMarkDto);

    @Mappings({
            @Mapping(target = "subject", qualifiedBy = SubjectMapper.FromDto.class),
            @Mapping(target = "period", qualifiedBy = PeriodMapper.FromDto.class),
            @Mapping(target = "pupil", qualifiedBy = PupilMapper.FromDto.class)
    })
    PeriodMark fromDtoWithRelatedObjects(PeriodMarkDto periodMarkDto);

    @Mappings({
            @Mapping(target = "subject", ignore = true),
            @Mapping(target = "period", ignore = true),
            @Mapping(target = "pupil", ignore = true)
    })
    PeriodMarkDto toDto(PeriodMark periodMark);

    @Mappings({
            @Mapping(target = "subject", qualifiedBy = SubjectMapper.ToDto.class),
            @Mapping(target = "period", qualifiedBy = PeriodMapper.ToDto.class),
            @Mapping(target = "pupil", qualifiedBy = PupilMapper.ToDto.class)
    })
    PeriodMarkDto toDtoWithRelatedObjects(PeriodMark periodMark);

}
