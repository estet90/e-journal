package ru.salix.ejournal.api.controller.builder;

import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.controller.dto.SchoolClassDto;
import ru.salix.ejournal.api.entity.SchoolClass;

@Component
public class SchoolClassDtoBuilder extends AbstractBuilder<SchoolClassDto, SchoolClass> {

    @Override
    public SchoolClassDto build(SchoolClass schoolClass) {
        return null;
    }

}
