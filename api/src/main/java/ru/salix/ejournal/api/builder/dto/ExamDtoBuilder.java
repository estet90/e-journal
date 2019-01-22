package ru.salix.ejournal.api.builder.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.controller.dto.ExamDto;
import ru.salix.ejournal.api.entity.Exam;
import ru.salix.ejournal.api.entity.SchoolClass;
import ru.salix.ejournal.api.entity.Subject;
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

    public ExamDto build(Exam exam, SchoolClass schoolClass, Subject subject) {
        var examDto = build(exam);
        examDto.setSchoolClass(schoolClassDtoBuilder.build(schoolClass));
        examDto.setSubject(subjectDtoBuilder.build(subject));
        return examDto;
    }

}
