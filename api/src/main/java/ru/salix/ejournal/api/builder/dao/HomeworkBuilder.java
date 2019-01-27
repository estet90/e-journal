package ru.salix.ejournal.api.builder.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.controller.dto.HomeworkDto;
import ru.salix.ejournal.api.entity.Homework;
import ru.salix.ejournal.api.mapper.HomeworkMapper;

@Component
@RequiredArgsConstructor
public class HomeworkBuilder extends AbstractDaoBuilder<Homework, HomeworkDto> {

    private final HomeworkMapper homeworkMapper;

    @Override
    public Homework build(HomeworkDto homeworkDto) {
        return homeworkMapper.homeworkDtoToHomework(homeworkDto);
    }

}
