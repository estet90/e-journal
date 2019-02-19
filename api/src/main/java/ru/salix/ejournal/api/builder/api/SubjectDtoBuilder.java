package ru.salix.ejournal.api.builder.api;

import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.SubjectMapper;
import ru.salix.ejournal.api.model.api.SubjectDto;
import ru.salix.ejournal.api.model.dao.Subject;

@Component
public class SubjectDtoBuilder extends BaseDtoBuilder<SubjectDto, Subject> {

    public SubjectDtoBuilder(SubjectMapper mapper) {
        super(mapper);
    }

}
