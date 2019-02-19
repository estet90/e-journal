package ru.salix.ejournal.api.builder.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.PupilMapper;
import ru.salix.ejournal.api.model.api.PupilDto;
import ru.salix.ejournal.api.model.dao.Pupil;

@Component
@RequiredArgsConstructor
public class PupilBuilder extends AbstractDaoBuilder<Pupil, PupilDto> {

    private final PupilMapper pupilMapper;

    private final SchoolClassBuilder schoolClassBuilder;

    @Override
    public Pupil build(PupilDto pupilDto) {
        return pupilMapper.fromDto(pupilDto);
    }

    @Override
    public Pupil buildWithRelatedObjects(PupilDto pupilDto) {
        var pupil = build(pupilDto);
        pupil.setSchoolClass(schoolClassBuilder.build(pupilDto.getSchoolClass()));
        return pupil;
    }

}
