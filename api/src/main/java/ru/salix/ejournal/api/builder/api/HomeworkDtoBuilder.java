package ru.salix.ejournal.api.builder.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.model.api.HomeworkDto;
import ru.salix.ejournal.api.model.dao.Homework;
import ru.salix.ejournal.api.mapper.HomeworkMapper;

@Component
@RequiredArgsConstructor
public class HomeworkDtoBuilder extends AbstractDtoBuilder<HomeworkDto, Homework> {

    private final HomeworkMapper homeworkMapper;
    private final LessonDtoBuilder lessonDtoBuilder;

    @Override
    public HomeworkDto build(Homework homework) {
        return homeworkMapper.toDto(homework);
    }

    @Override
    public HomeworkDto buildWithRelatedObjects(Homework homework) {
        var homeworkDto = build(homework);
        homeworkDto.setLessonComplete(lessonDtoBuilder.build(homework.getLessonComplete()));
        homeworkDto.setLessonReceive(lessonDtoBuilder.build(homework.getLessonReceive()));
        return homeworkDto;
    }

}
