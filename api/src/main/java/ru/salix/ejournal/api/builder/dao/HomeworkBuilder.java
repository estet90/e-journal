package ru.salix.ejournal.api.builder.dao;

import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.HomeworkMapper;
import ru.salix.ejournal.api.model.api.HomeworkDto;
import ru.salix.ejournal.api.model.dao.Homework;

@Component
public class HomeworkBuilder extends BaseDaoBuilder<Homework, HomeworkDto> {

    public HomeworkBuilder(HomeworkMapper mapper) {
        super(mapper);
    }

}
