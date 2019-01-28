package ru.salix.ejournal.api.builder.api;

import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.model.api.SchoolClassDto;
import ru.salix.ejournal.api.model.dao.SchoolClass;

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
