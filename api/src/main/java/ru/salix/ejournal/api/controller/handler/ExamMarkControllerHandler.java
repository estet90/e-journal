package ru.salix.ejournal.api.controller.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.builder.api.ExamMarkDtoBuilder;
import ru.salix.ejournal.api.builder.dao.ExamMarkBuilder;
import ru.salix.ejournal.api.dao.service.ExamMarkService;
import ru.salix.ejournal.api.dao.service.ExamService;
import ru.salix.ejournal.api.dao.service.PupilService;
import ru.salix.ejournal.api.model.api.ExamMarkDto;
import ru.salix.ejournal.api.model.api.filter.ExamMarkFilterDto;
import ru.salix.ejournal.api.model.dao.ExamMark;

import java.util.List;
import java.util.function.Supplier;

import static java.util.Optional.ofNullable;
import static ru.salix.ejournal.api.helper.ExceptionHelper.notFoundInDbException;
import static ru.salix.ejournal.api.helper.OperationHelper.checkField;
import static ru.salix.ejournal.api.helper.OperationHelper.wrap;

@Component
@RequiredArgsConstructor
public class ExamMarkControllerHandler {

    private final ExamMarkDtoBuilder examMarkDtoBuilder;
    private final ExamMarkService examMarkService;
    private final ExamMarkBuilder examMarkBuilder;

    private final ExamService examService;
    private final PupilService pupilService;

    public List<ExamMarkDto> findExamMarks() {
        return wrap(() -> examMarkDtoBuilder.buildList(examMarkService::findAll));
    }

    public ExamMarkDto findExamMarkById(Long id) {
        return wrap(() -> examMarkDtoBuilder.build(examMarkService.findById(id)));
    }

    public List<ExamMarkDto> filter(ExamMarkFilterDto filter) {
        return wrap(() -> examMarkDtoBuilder.buildList(() -> examMarkService.filter(filter)));
    }

    public Long createExamMark(ExamMarkDto examMarkDto) {
        return saveAndReturnId(examMarkDto, () -> examMarkBuilder.buildWithRelatedObjects(examMarkDto));
    }

    public Long updateExamMark(ExamMarkDto examMarkDto, Long id) {
        return ofNullable(examMarkService.findById(id))
                .map(exam -> saveAndReturnId(examMarkDto, () -> examMarkBuilder.buildWithRelatedObjects(examMarkDto, id)))
                .orElseThrow(() -> notFoundInDbException(String.format("Не найдена оценка по id = %s", id)));
    }

    public Long deleteExamMark(Long id) {
        return wrap(() -> {
            examMarkService.deleteById(id);
            return 1L;
        });
    }

    private Long saveAndReturnId(ExamMarkDto examMarkDto, Supplier<ExamMark> builder) {
        return wrap(() -> {
            checkField(examMarkDto.getExam(), examService, "Экзамен не найден");
            checkField(examMarkDto.getPupil(), pupilService, "Ученик не найден");
            return examMarkService.saveAndReturnId(builder.get());
        });
    }

}
