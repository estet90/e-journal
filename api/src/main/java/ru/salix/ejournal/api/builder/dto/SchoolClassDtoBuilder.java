package ru.salix.ejournal.api.builder.dto;

import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.controller.dto.SchoolClassDto;
import ru.salix.ejournal.api.entity.SchoolClass;

@Component
public class SchoolClassDtoBuilder extends AbstractDtoBuilder<SchoolClassDto, SchoolClass> {

    @Override
    public SchoolClassDto build(SchoolClass schoolClass) {
        return null;
    }

    @Override
    public SchoolClassDto buildWithRelatedObjects(SchoolClass entity) {
        return null;
    }

}
