package ru.salix.ejournal.api.controller.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.builder.api.LessonMarkDtoBuilder;
import ru.salix.ejournal.api.builder.dao.LessonMarkBuilder;
import ru.salix.ejournal.api.dao.service.*;
import ru.salix.ejournal.api.model.api.LessonMarkDto;
import ru.salix.ejournal.api.model.api.filter.LessonMarkFilterDto;
import ru.salix.ejournal.api.model.dao.LessonMark;

import java.util.List;
import java.util.function.Supplier;

import static java.util.Optional.ofNullable;
import static ru.salix.ejournal.api.helper.ExceptionHelper.notFoundInDbException;
import static ru.salix.ejournal.api.helper.OperationHelper.checkField;
import static ru.salix.ejournal.api.helper.OperationHelper.wrap;

@Component
@RequiredArgsConstructor
public class LessonMarkControllerHandler {

    private final LessonMarkDtoBuilder lessonMarkDtoBuilder;
    private final LessonMarkService lessonMarkService;
    private final LessonMarkBuilder lessonMarkBuilder;

    private final LessonService lessonService;
    private final PupilService pupilService;
    private final TestService testService;
    private final HomeworkService homeworkService;

    public List<LessonMarkDto> findLessonMarks() {
        return wrap(() -> lessonMarkDtoBuilder.buildList(lessonMarkService::findAll));
    }

    public LessonMarkDto findLessonMarkById(Long id) {
        return wrap(() -> lessonMarkDtoBuilder.buildWithRelatedObjects(lessonMarkService.findById(id)));
    }

    public List<LessonMarkDto> filter(LessonMarkFilterDto filter) {
        return wrap(() -> lessonMarkDtoBuilder.buildList(() -> lessonMarkService.filter(filter)));
    }

    public Long createLessonMark(LessonMarkDto lessonMarkDto) {
        return saveAndReturnId(lessonMarkDto, () -> lessonMarkBuilder.buildWithRelatedObjects(lessonMarkDto));
    }

    public Long updateLessonMark(LessonMarkDto lessonMarkDto, Long id) {
        return ofNullable(lessonMarkService.findById(id))
                .map(exam -> saveAndReturnId(lessonMarkDto, () -> lessonMarkBuilder.buildWithRelatedObjects(lessonMarkDto, id)))
                .orElseThrow(() -> notFoundInDbException(String.format("Не найдена оценка по id = %s", id)));
    }

    public Long deleteLessonMark(Long id) {
        return wrap(() -> {
            lessonMarkService.deleteById(id);
            return 1L;
        });
    }

    private Long saveAndReturnId(LessonMarkDto lessonMarkDto, Supplier<LessonMark> builder) {
        return wrap(() -> {
            checkField(lessonMarkDto.getLesson(), lessonService, "Урок не найден");
            checkField(lessonMarkDto.getPupil(), pupilService, "Ученик не найден");
            checkField(lessonMarkDto.getTest(), testService, "Контрольная не найдена");
            checkField(lessonMarkDto.getHomework(), homeworkService, "Домашнее задание не найдено");
            return lessonMarkService.saveAndReturnId(builder.get());
        });
    }

}
