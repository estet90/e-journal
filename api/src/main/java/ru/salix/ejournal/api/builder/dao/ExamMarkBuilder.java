package ru.salix.ejournal.api.builder.dao;

import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.ExamMarkMapper;
import ru.salix.ejournal.api.model.api.ExamMarkDto;
import ru.salix.ejournal.api.model.dao.ExamMark;

@Component
public class ExamMarkBuilder extends BaseDaoBuilder<ExamMark, ExamMarkDto> {

    public ExamMarkBuilder(ExamMarkMapper mapper) {
        super(mapper);
    }

}
