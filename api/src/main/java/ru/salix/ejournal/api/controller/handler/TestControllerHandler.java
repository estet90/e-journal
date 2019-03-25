package ru.salix.ejournal.api.controller.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.builder.api.TestDtoBuilder;
import ru.salix.ejournal.api.builder.dao.TestBuilder;
import ru.salix.ejournal.api.dao.service.LessonService;
import ru.salix.ejournal.api.dao.service.TestService;
import ru.salix.ejournal.api.model.api.TestDto;
import ru.salix.ejournal.api.model.api.filter.TestFilterDto;
import ru.salix.ejournal.api.model.dao.Test;

import java.util.List;
import java.util.function.Supplier;

import static java.util.Optional.ofNullable;
import static ru.salix.ejournal.api.helper.ExceptionHelper.notFoundInDbException;
import static ru.salix.ejournal.api.helper.OperationHelper.checkField;
import static ru.salix.ejournal.api.helper.OperationHelper.wrap;

@Component
@RequiredArgsConstructor
public class TestControllerHandler {

    private final TestDtoBuilder testDtoBuilder;
    private final TestService testService;
    private final TestBuilder testBuilder;

    private final LessonService lessonService;

    public List<TestDto> findTests() {
        return wrap(() -> testDtoBuilder.buildList(testService::findAll));
    }

    public TestDto findTestById(Long id) {
        return wrap(() -> testDtoBuilder.buildWithRelatedObjects(testService.findById(id)));
    }

    public List<TestDto> filter(TestFilterDto filter) {
        return wrap(() -> testDtoBuilder.buildList(testService.filter(filter)));
    }

    public Long createTest(TestDto testDto) {
        return saveAndReturnId(testDto, () -> testBuilder.build(testDto));
    }

    public Long updateTest(TestDto testDto, Long id) {
        return ofNullable(testService.findById(id))
                .map(test -> saveAndReturnId(testDto, () -> testBuilder.buildWithRelatedObjects(testDto, id)))
                .orElseThrow(() -> notFoundInDbException(String.format("Не найдена контрольная по id = %s", id)));
    }

    public Long saveAndReturnId(TestDto testDto, Supplier<Test> builder) {
        return wrap(() -> {
            checkField(testDto.getLesson(), lessonService, "Урок не найден по id");
            return testService.saveAndReturnId(builder.get());
        });
    }

}
