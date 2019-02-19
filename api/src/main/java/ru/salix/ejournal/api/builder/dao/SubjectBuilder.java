package ru.salix.ejournal.api.builder.dao;

import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.SubjectMapper;
import ru.salix.ejournal.api.model.api.SubjectDto;
import ru.salix.ejournal.api.model.dao.Subject;

@Component
public class SubjectBuilder extends BaseDaoBuilder<Subject, SubjectDto> {

    public SubjectBuilder(SubjectMapper mapper) {
        super(mapper);
    }

}
