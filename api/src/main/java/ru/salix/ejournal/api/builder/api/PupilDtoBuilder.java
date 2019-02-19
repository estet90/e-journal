package ru.salix.ejournal.api.builder.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.PupilMapper;
import ru.salix.ejournal.api.model.api.PupilDto;
import ru.salix.ejournal.api.model.dao.Pupil;

@Component
@RequiredArgsConstructor
public class PupilDtoBuilder extends AbstractDtoBuilder<PupilDto, Pupil> {

    private final PupilMapper pupilMapper;

    private final SchoolClassDtoBuilder schoolClassDtoBuilder;

    @Override
    public PupilDto build(Pupil pupil) {
        return pupilMapper.toDto(pupil);
    }

    @Override
    public PupilDto buildWithRelatedObjects(Pupil pupil) {
        var pupilDto = build(pupil);
        pupilDto.setSchoolClass(schoolClassDtoBuilder.build(pupil.getSchoolClass()));
        return pupilDto;
    }

}
