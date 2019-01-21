package ru.salix.ejournal.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.salix.ejournal.api.controller.dto.PupilDto;
import ru.salix.ejournal.api.entity.Pupil;

@Mapper(componentModel = "spring")
public interface PupilMapper {

    @Mapping(target = "schoolClass", ignore = true)
    Pupil pupilDtoToPupil(PupilDto pupilDto);

    @Mapping(target = "schoolClass", ignore = true)
    PupilDto pupilToPupilDto(Pupil pupil);

}
