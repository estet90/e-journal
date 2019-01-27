package ru.salix.ejournal.api.builder.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.controller.dto.ExamMarkDto;
import ru.salix.ejournal.api.entity.ExamMark;
import ru.salix.ejournal.api.mapper.ExamMarkMapper;

@Component
@RequiredArgsConstructor
public class ExamMarkDtoBuilder extends AbstractDtoBuilder<ExamMarkDto, ExamMark> {

    private final ExamMarkMapper examMarkMapper;
    private final ExamDtoBuilder examDtoBuilder;

    @Override
    public ExamMarkDto build(ExamMark examMark) {
        return examMarkMapper.examMarkToExamMarkDto(examMark);
    }

    @Override
    public ExamMarkDto buildWithRelatedObjects(ExamMark examMark) {
        var examMarkDto = build(examMark);
        examMarkDto.setExam(examDtoBuilder.build(examMark.getExam()));
        return examMarkDto;
    }

}
