package ru.salix.ejournal.api.builder.api;

import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.PupilMapper;
import ru.salix.ejournal.api.model.api.PupilDto;
import ru.salix.ejournal.api.model.dao.Pupil;

@Component
public class PupilDtoBuilder extends BaseDtoBuilder<PupilDto, Pupil> {

    public PupilDtoBuilder(PupilMapper mapper) {
        super(mapper);
    }

}
