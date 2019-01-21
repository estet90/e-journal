package ru.salix.ejournal.api.builder.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.controller.dto.SubjectDto;
import ru.salix.ejournal.api.entity.Subject;
import ru.salix.ejournal.api.mapper.SubjectMapper;

@Component
@RequiredArgsConstructor
public class SubjectDtoBuilder extends AbstractDtoBuilder<SubjectDto, Subject> {

    private final SubjectMapper subjectMapper;

    @Override
    public SubjectDto build(Subject subject) {
        return subjectMapper.subjectToSubjectDto(subject);
    }

}
