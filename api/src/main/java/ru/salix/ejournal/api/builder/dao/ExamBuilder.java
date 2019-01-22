package ru.salix.ejournal.api.builder.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.controller.dto.ExamDto;
import ru.salix.ejournal.api.entity.Exam;
import ru.salix.ejournal.api.mapper.ExamMapper;

@Component
@RequiredArgsConstructor
public class ExamBuilder extends AbstractDaoBuilder<Exam, ExamDto> {

    private final ExamMapper examMapper;

    private final SchoolClassBuilder schoolClassBuilder;
    private final SubjectBuilder subjectBuilder;

    @Override
    public Exam build(ExamDto examDto) {
        return examMapper.examDtoToExam(examDto);
    }

    public Exam buildWithRelatedObjects(ExamDto examDto) {
        var exam = build(examDto);
        exam.setSchoolClass(schoolClassBuilder.build(examDto.getSchoolClass()));
        exam.setSubject(subjectBuilder.build(examDto.getSubject()));
        return exam;
    }

    public Exam buildWithRelatedObjects(ExamDto examDto, Long id) {
        var exam = buildWithRelatedObjects(examDto);
        exam.setId(id);
        return exam;
    }

}

