package ru.salix.ejournal.api.controller.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.builder.api.HomeworkDtoBuilder;
import ru.salix.ejournal.api.builder.dao.HomeworkBuilder;
import ru.salix.ejournal.api.dao.service.HomeworkService;
import ru.salix.ejournal.api.dao.service.LessonService;
import ru.salix.ejournal.api.model.api.HomeworkDto;
import ru.salix.ejournal.api.model.api.filter.HomeworkFilterDto;
import ru.salix.ejournal.api.model.dao.Homework;

import java.util.List;
import java.util.function.Supplier;

import static java.util.Optional.ofNullable;
import static ru.salix.ejournal.api.helper.ExceptionHelper.notFoundInDbException;
import static ru.salix.ejournal.api.helper.OperationHelper.checkField;
import static ru.salix.ejournal.api.helper.OperationHelper.wrap;

@Component
@RequiredArgsConstructor
public class HomeworkControllerHandler {

    private final HomeworkDtoBuilder homeworkDtoBuilder;
    private final HomeworkService homeworkService;
    private final HomeworkBuilder homeworkBuilder;
    private final LessonService lessonService;

    public List<HomeworkDto> findHomework() {
        return wrap(() -> homeworkDtoBuilder.buildList(homeworkService::findAll));
    }

    public HomeworkDto findHomeworkById(Long id) {
        return wrap(() -> homeworkDtoBuilder.build(homeworkService.findById(id)));
    }

    public List<HomeworkDto> filter(HomeworkFilterDto filter) {
        return wrap(() -> homeworkDtoBuilder.buildList(homeworkService.filter(filter)));
    }

    public Long createHomework(HomeworkDto homeworkDto) {
        return saveAndReturnId(homeworkDto, () -> homeworkBuilder.buildWithRelatedObjects(homeworkDto));
    }

    public Long updateHomework(HomeworkDto homeworkDto, Long id) {
        return ofNullable(homeworkService.findById(id))
                .map(homework -> saveAndReturnId(homeworkDto, () -> homeworkBuilder.buildWithRelatedObjects(homeworkDto, id)))
                .orElseThrow(() -> notFoundInDbException(String.format("Не найдено домашнее задание по id = %s", id)));
    }

    public Long deleteHomework(Long id) {
        return wrap(() -> {
            homeworkService.deleteById(id);
            return 1L;
        });
    }

    private Long saveAndReturnId(HomeworkDto homeworkDto, Supplier<Homework> builder) {
        return wrap(() -> {
            checkField(homeworkDto.getLessonComplete(), lessonService, "Урок, на котором выдали домашнее задание, не найден");
            checkField(homeworkDto.getLessonReceive(), lessonService, "Урок, к которому необходимо подготовить домашнее задание, не найден");
            return homeworkService.saveAndReturnId(builder.get());
        });
    }

}
