package ru.salix.ejournal.api.builder.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.model.api.ExamDto;
import ru.salix.ejournal.api.model.dao.Exam;
import ru.salix.ejournal.api.mapper.ExamMapper;

@Component
@RequiredArgsConstructor
public class ExamDtoBuilder extends AbstractDtoBuilder<ExamDto, Exam> {

    private final ExamMapper examMapper;
    private final SchoolClassDtoBuilder schoolClassDtoBuilder;
    private final SubjectDtoBuilder subjectDtoBuilder;

    @Override
    public ExamDto build(Exam exam) {
        return examMapper.examToExamDto(exam);
    }

    @Override
    public ExamDto buildWithRelatedObjects(Exam exam) {
        var examDto = build(exam);
        examDto.setSchoolClass(schoolClassDtoBuilder.build(exam.getSchoolClass()));
        examDto.setSubject(subjectDtoBuilder.build(exam.getSubject()));
        return examDto;
    }

}