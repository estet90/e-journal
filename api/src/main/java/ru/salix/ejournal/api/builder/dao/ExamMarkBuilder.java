package ru.salix.ejournal.api.builder.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.model.api.ExamMarkDto;
import ru.salix.ejournal.api.model.dao.ExamMark;
import ru.salix.ejournal.api.mapper.ExamMarkMapper;

@Component
@RequiredArgsConstructor
public class ExamMarkBuilder extends AbstractDaoBuilder<ExamMark, ExamMarkDto> {

    private final ExamMarkMapper examMarkMapper;

    @Override
    public ExamMark build(ExamMarkDto examMarkDto) {
        return examMarkMapper.examMarkDtoToExamMark(examMarkDto);
    }

}
