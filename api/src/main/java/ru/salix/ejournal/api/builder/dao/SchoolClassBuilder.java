package ru.salix.ejournal.api.builder.dao;

import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.SchoolClassMapper;
import ru.salix.ejournal.api.model.api.SchoolClassDto;
import ru.salix.ejournal.api.model.dao.SchoolClass;

@Component
public class SchoolClassBuilder extends BaseDaoBuilder<SchoolClass, SchoolClassDto> {

    public SchoolClassBuilder(SchoolClassMapper mapper) {
        super(mapper);
    }

}
