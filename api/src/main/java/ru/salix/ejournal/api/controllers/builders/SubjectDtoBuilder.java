package ru.salix.ejournal.api.controllers.builders;

import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.controllers.dto.SubjectDto;
import ru.salix.ejournal.api.controllers.dto.TeacherDto;
import ru.salix.ejournal.api.entities.Subject;

import java.util.List;

@Component
public class SubjectDtoBuilder extends AbstractBuilder<SubjectDto, Subject> {

    @Override
    public SubjectDto build(Subject subject) {
        return SubjectDto.builder()
                .id(subject.getId())
                .name(subject.getName())
                .build();
    }

    public SubjectDto build(Subject subject, List<TeacherDto> teachers) {
        return SubjectDto.builder()
                .id(subject.getId())
                .name(subject.getName())
                .teachers(teachers)
                .build();
    }

}
