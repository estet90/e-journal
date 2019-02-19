package ru.salix.ejournal.api.builder.dao;

import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.PupilMapper;
import ru.salix.ejournal.api.model.api.PupilDto;
import ru.salix.ejournal.api.model.dao.Pupil;

@Component
public class PupilBuilder extends BaseDaoBuilder<Pupil, PupilDto> {

    public PupilBuilder(PupilMapper mapper) {
        super(mapper);
    }

}
