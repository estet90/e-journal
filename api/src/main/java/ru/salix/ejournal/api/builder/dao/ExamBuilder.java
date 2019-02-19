package ru.salix.ejournal.api.builder.dao;

import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.ExamMapper;
import ru.salix.ejournal.api.model.api.ExamDto;
import ru.salix.ejournal.api.model.dao.Exam;

@Component
public class ExamBuilder extends BaseDaoBuilder<Exam, ExamDto> {

    public ExamBuilder(ExamMapper mapper) {
        super(mapper);
    }

}

