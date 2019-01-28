package ru.salix.ejournal.api.builder.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.model.api.SubjectDto;
import ru.salix.ejournal.api.model.dao.Subject;
import ru.salix.ejournal.api.mapper.SubjectMapper;

@Component
@RequiredArgsConstructor
public class SubjectBuilder extends AbstractDaoBuilder<Subject, SubjectDto> {

    private final SubjectMapper subjectMapper;

    @Override
    public Subject build(SubjectDto subjectDto) {
        return subjectMapper.subjectDtoToSubject(subjectDto);
    }

}
