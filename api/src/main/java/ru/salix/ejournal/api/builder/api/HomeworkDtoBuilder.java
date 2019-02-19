package ru.salix.ejournal.api.builder.api;

import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.HomeworkMapper;
import ru.salix.ejournal.api.model.api.HomeworkDto;
import ru.salix.ejournal.api.model.dao.Homework;

@Component
public class HomeworkDtoBuilder extends BaseDtoBuilder<HomeworkDto, Homework> {

    public HomeworkDtoBuilder(HomeworkMapper mapper) {
        super(mapper);
    }

}
