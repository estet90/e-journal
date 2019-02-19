package ru.salix.ejournal.api.builder.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.model.api.ExamMarkDto;
import ru.salix.ejournal.api.model.dao.ExamMark;
import ru.salix.ejournal.api.mapper.ExamMarkMapper;

@Component
@RequiredArgsConstructor
public class ExamMarkDtoBuilder extends AbstractDtoBuilder<ExamMarkDto, ExamMark> {

    private final ExamMarkMapper examMarkMapper;

    @Override
    public ExamMarkDto build(ExamMark examMark) {
        return examMarkMapper.toDto(examMark);
    }

    @Override
    public ExamMarkDto buildWithRelatedObjects(ExamMark examMark) {
        return examMarkMapper.toDtoWithRelatedObjects(examMark);
    }

}
