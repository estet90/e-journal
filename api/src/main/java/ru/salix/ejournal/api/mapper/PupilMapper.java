package ru.salix.ejournal.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.salix.ejournal.api.model.api.PupilDto;
import ru.salix.ejournal.api.model.dao.Pupil;

@Mapper(componentModel = "spring", uses = SchoolClassMapper.class)
public interface PupilMapper extends BaseMapper<Pupil, PupilDto> {

    @Mapping(target = "schoolClass", ignore = true)
    @FromDto
    Pupil fromDto(PupilDto pupilDto);

    @Mapping(target = "schoolClass", qualifiedBy = SchoolClassMapper.FromDto.class)
    Pupil fromDtoWithRelatedObjects(PupilDto pupilDto);

    @Mapping(target = "schoolClass", ignore = true)
    @ToDto
    PupilDto toDto(Pupil pupil);

    @Mapping(target = "schoolClass", qualifiedBy = SchoolClassMapper.ToDto.class)
    PupilDto toDtoWithRelatedObjects(Pupil pupil);

}
