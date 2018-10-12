package ru.salix.ejournal.api.controllers.builders;

import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.controllers.dto.SchoolClassDto;
import ru.salix.ejournal.api.entities.SchoolClass;

@Component
public class SchoolClassDtoBuilder extends AbstractBuilder<SchoolClassDto, SchoolClass> {

    @Override
    public SchoolClassDto build(SchoolClass schoolClass) {
        return null;
    }

}
