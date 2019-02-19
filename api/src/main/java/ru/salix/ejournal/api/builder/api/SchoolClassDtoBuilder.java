package ru.salix.ejournal.api.builder.api;

import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.SchoolClassMapper;
import ru.salix.ejournal.api.model.api.SchoolClassDto;
import ru.salix.ejournal.api.model.dao.SchoolClass;

@Component
public class SchoolClassDtoBuilder extends BaseDtoBuilder<SchoolClassDto, SchoolClass> {

    public SchoolClassDtoBuilder(SchoolClassMapper mapper) {
        super(mapper);
    }

}
