package ru.salix.ejournal.api.builder.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.model.api.HomeworkDto;
import ru.salix.ejournal.api.model.dao.Homework;
import ru.salix.ejournal.api.mapper.HomeworkMapper;

@Component
@RequiredArgsConstructor
public class HomeworkBuilder extends AbstractDaoBuilder<Homework, HomeworkDto> {

    private final HomeworkMapper homeworkMapper;

    private final LessonBuilder lessonBuilder;

    @Override
    public Homework build(HomeworkDto homeworkDto) {
        return homeworkMapper.homeworkDtoToHomework(homeworkDto);
    }

    @Override
    public Homework buildWithRelatedObjects(HomeworkDto homeworkDto) {
        var homework = build(homeworkDto);
        homework.setLessonComplete(lessonBuilder.build(homeworkDto.getLessonComplete()));
        homework.setLessonReceive(lessonBuilder.build(homeworkDto.getLessonReceive()));
        return homework;
    }

}
