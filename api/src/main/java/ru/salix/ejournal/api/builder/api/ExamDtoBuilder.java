package ru.salix.ejournal.api.builder.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.ExamMapper;
import ru.salix.ejournal.api.model.api.ExamDto;
import ru.salix.ejournal.api.model.dao.Exam;

@Component
@RequiredArgsConstructor
public class ExamDtoBuilder extends AbstractDtoBuilder<ExamDto, Exam> {

    private final ExamMapper examMapper;

    @Override
    public ExamDto build(Exam exam) {
        return examMapper.toDto(exam);
    }

    @Override
    public ExamDto buildWithRelatedObjects(Exam exam) {
        return examMapper.toDtoWithRelatedObjects(exam);
    }

}
