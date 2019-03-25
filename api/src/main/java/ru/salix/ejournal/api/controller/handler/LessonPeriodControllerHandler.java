package ru.salix.ejournal.api.controller.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.builder.api.LessonPeriodDtoBuilder;
import ru.salix.ejournal.api.dao.service.LessonPeriodService;
import ru.salix.ejournal.api.model.api.LessonPeriodDto;
import ru.salix.ejournal.api.model.api.filter.LessonPeriodFilterDto;

import java.util.List;

import static ru.salix.ejournal.api.helper.OperationHelper.wrap;

@Component
@RequiredArgsConstructor
public class LessonPeriodControllerHandler {

    private final LessonPeriodDtoBuilder lessonPeriodDtoBuilder;
    private final LessonPeriodService lessonPeriodService;

    public List<LessonPeriodDto> findLessonPeriods() {
        return wrap(() -> lessonPeriodDtoBuilder.buildList(lessonPeriodService::findAll));
    }

    public LessonPeriodDto findLessonPeriodById(Long id) {
        return wrap(() -> lessonPeriodDtoBuilder.buildWithRelatedObjects(lessonPeriodService.findById(id)));
    }

    public List<LessonPeriodDto> filter(LessonPeriodFilterDto filter) {
        return wrap(() -> lessonPeriodDtoBuilder.buildList(lessonPeriodService.filter(filter)));
    }

}
