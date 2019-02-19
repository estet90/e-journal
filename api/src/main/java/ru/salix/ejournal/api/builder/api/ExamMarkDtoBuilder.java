package ru.salix.ejournal.api.builder.api;

import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.ExamMarkMapper;
import ru.salix.ejournal.api.model.api.ExamMarkDto;
import ru.salix.ejournal.api.model.dao.ExamMark;

@Component
public class ExamMarkDtoBuilder extends BaseDtoBuilder<ExamMarkDto, ExamMark> {

    public ExamMarkDtoBuilder(ExamMarkMapper mapper) {
        super(mapper);
    }

}
