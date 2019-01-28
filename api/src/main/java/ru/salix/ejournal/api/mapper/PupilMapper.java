package ru.salix.ejournal.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.salix.ejournal.api.model.api.PupilDto;
import ru.salix.ejournal.api.model.dao.Pupil;

@Mapper(componentModel = "spring")
public interface PupilMapper {

    @Mapping(target = "schoolClass", ignore = true)
    Pupil pupilDtoToPupil(PupilDto pupilDto);

    @Mapping(target = "schoolClass", ignore = true)
    PupilDto pupilToPupilDto(Pupil pupil);

}
