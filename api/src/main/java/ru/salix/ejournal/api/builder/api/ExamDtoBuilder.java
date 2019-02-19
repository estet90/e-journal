package ru.salix.ejournal.api.builder.api;

import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.ExamMapper;
import ru.salix.ejournal.api.model.api.ExamDto;
import ru.salix.ejournal.api.model.dao.Exam;

@Component
public class ExamDtoBuilder extends BaseDtoBuilder<ExamDto, Exam> {

    public ExamDtoBuilder(ExamMapper mapper) {
        super(mapper);
    }

}
