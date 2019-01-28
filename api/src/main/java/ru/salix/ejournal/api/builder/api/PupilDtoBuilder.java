package ru.salix.ejournal.api.builder.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.model.api.PupilDto;
import ru.salix.ejournal.api.model.dao.Pupil;
import ru.salix.ejournal.api.mapper.PupilMapper;

@Component
@RequiredArgsConstructor
public class PupilDtoBuilder extends AbstractDtoBuilder<PupilDto, Pupil> {

    private final PupilMapper pupilMapper;

    @Override
    public PupilDto build(Pupil pupil) {
        return pupilMapper.pupilToPupilDto(pupil);
    }

    @Override
    public PupilDto buildWithRelatedObjects(Pupil entity) {
        return null;
    }

}
