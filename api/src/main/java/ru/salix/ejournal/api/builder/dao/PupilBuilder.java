package ru.salix.ejournal.api.builder.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.controller.dto.PupilDto;
import ru.salix.ejournal.api.entity.Pupil;
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
