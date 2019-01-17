package ru.salix.ejournal.api.controller.builder;

import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.controller.dto.SubjectDto;
import ru.salix.ejournal.api.entity.Subject;

@Component
public class SubjectDtoBuilder extends AbstractBuilder<SubjectDto, Subject> {

    @Override
    public SubjectDto build(Subject subject) {
        return SubjectDto.builder()
                .id(subject.getId())
                .name(subject.getName())
                .build();
    }

}
