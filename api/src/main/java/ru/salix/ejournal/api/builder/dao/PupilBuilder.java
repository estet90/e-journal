package ru.salix.ejournal.api.builder.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.model.api.PupilDto;
import ru.salix.ejournal.api.model.dao.Pupil;
import ru.salix.ejournal.api.mapper.PupilMapper;

@Component
@RequiredArgsConstructor
public class PupilBuilder extends AbstractDaoBuilder<Pupil, PupilDto> {

    private final PupilMapper pupilMapper;

    @Override
    public Pupil build(PupilDto pupilDto) {
        return pupilMapper.pupilDtoToPupil(pupilDto);
    }

}
