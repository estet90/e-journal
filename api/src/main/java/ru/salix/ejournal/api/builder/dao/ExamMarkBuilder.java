package ru.salix.ejournal.api.builder.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.ExamMarkMapper;
import ru.salix.ejournal.api.model.api.ExamMarkDto;
import ru.salix.ejournal.api.model.dao.ExamMark;

@Component
@RequiredArgsConstructor
public class ExamMarkBuilder extends AbstractDaoBuilder<ExamMark, ExamMarkDto> {

    private final ExamMarkMapper examMarkMapper;

    @Override
    public ExamMark build(ExamMarkDto examMarkDto) {
        return examMarkMapper.fromDto(examMarkDto);
    }

    @Override
    public ExamMark buildWithRelatedObjects(ExamMarkDto examMarkDto) {
        return examMarkMapper.fromDtoWithRelatedObjects(examMarkDto);
    }

}
