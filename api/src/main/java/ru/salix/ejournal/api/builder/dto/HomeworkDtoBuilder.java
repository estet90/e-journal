package ru.salix.ejournal.api.builder.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.controller.dto.HomeworkDto;
import ru.salix.ejournal.api.entity.Homework;
import ru.salix.ejournal.api.mapper.HomeworkMapper;

@Component
@RequiredArgsConstructor
public class HomeworkDtoBuilder extends AbstractDtoBuilder<HomeworkDto, Homework> {

    private final HomeworkMapper homeworkMapper;
    private final LessonDtoBuilder lessonDtoBuilder;

    @Override
    public HomeworkDto build(Homework homework) {
        return homeworkMapper.homeworkToHomeworkDto(homework);
    }

    @Override
    public HomeworkDto buildWithRelatedObjects(Homework homework) {
        var homeworkDto = build(homework);
        homeworkDto.setLessonComplete(lessonDtoBuilder.build(homework.getLessonComplete()));
        homeworkDto.setLessonReceive(lessonDtoBuilder.build(homework.getLessonReceive()));
        return homeworkDto;
    }

}
