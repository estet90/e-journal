package ru.salix.ejournal.api.builder.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.SubjectMapper;
import ru.salix.ejournal.api.model.api.SubjectDto;
import ru.salix.ejournal.api.model.dao.Subject;

@Component
@RequiredArgsConstructor
public class SubjectBuilder extends AbstractDaoBuilder<Subject, SubjectDto> {

    private final SubjectMapper subjectMapper;

    private final TeacherBuilder teacherBuilder;

    @Override
    public Subject build(SubjectDto subjectDto) {
        return subjectMapper.subjectDtoToSubject(subjectDto);
    }

    @Override
    public Subject buildWithRelatedObjects(SubjectDto subjectDto) {
        var subject = build(subjectDto);
        subject.setTeachers(teacherBuilder.buildList(subjectDto.getTeachers()));
        return subject;
    }

}
