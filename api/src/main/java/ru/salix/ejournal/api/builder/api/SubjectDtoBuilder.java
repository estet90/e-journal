package ru.salix.ejournal.api.builder.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.SubjectMapper;
import ru.salix.ejournal.api.model.api.SubjectDto;
import ru.salix.ejournal.api.model.dao.Subject;

@Component
@RequiredArgsConstructor
public class SubjectDtoBuilder extends AbstractDtoBuilder<SubjectDto, Subject> {

    private final SubjectMapper subjectMapper;

    private final TeacherDtoBuilder teacherDtoBuilder;

    @Override
    public SubjectDto build(Subject subject) {
        return subjectMapper.subjectToSubjectDto(subject);
    }

    @Override
    public SubjectDto buildWithRelatedObjects(Subject subject) {
        var subjectDto = build(subject);
        subjectDto.setTeachers(teacherDtoBuilder.buildList(subject.getTeachers()));
        return subjectDto;
    }

}
