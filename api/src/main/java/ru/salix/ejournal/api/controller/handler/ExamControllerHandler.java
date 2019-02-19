package ru.salix.ejournal.api.controller.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.builder.api.ExamDtoBuilder;
import ru.salix.ejournal.api.builder.dao.ExamBuilder;
import ru.salix.ejournal.api.dao.service.ExamService;
import ru.salix.ejournal.api.dao.service.SchoolClassService;
import ru.salix.ejournal.api.dao.service.SubjectService;
import ru.salix.ejournal.api.model.api.ExamDto;
import ru.salix.ejournal.api.model.api.filter.ExamFilterDto;
import ru.salix.ejournal.api.model.dao.Exam;

import java.util.List;
import java.util.function.Supplier;

import static java.util.Optional.ofNullable;
import static ru.salix.ejournal.api.helper.ExceptionHelper.notFoundInDbException;
import static ru.salix.ejournal.api.helper.OperationHelper.checkField;
import static ru.salix.ejournal.api.helper.OperationHelper.wrap;

@Component
@RequiredArgsConstructor
public class ExamControllerHandler {

    private final ExamService examService;
    private final ExamDtoBuilder examDtoBuilder;
    private final ExamBuilder examBuilder;

    private final SubjectService subjectService;

    private final SchoolClassService schoolClassService;

    public List<ExamDto> findExams() {
        return wrap(() -> examDtoBuilder.buildList(examService::findAll));
    }

    public ExamDto findExamById(Long id) {
        return wrap(() -> examDtoBuilder.build(examService.findById(id)));
    }

    public List<ExamDto> filter(ExamFilterDto filter) {
        return wrap(() -> examDtoBuilder.buildList(() -> examService.filter(filter)));
    }

    public Long createExam(ExamDto examDto) {
        return saveAndReturnId(examDto, () -> examBuilder.buildWithRelatedObjects(examDto));
    }

    public Long updateExam(ExamDto examDto, Long id) {
        return ofNullable(examService.findById(id))
                .map(exam -> saveAndReturnId(examDto, () -> examBuilder.buildWithRelatedObjects(examDto, id)))
                .orElseThrow(() -> notFoundInDbException(String.format("Не найден экзамен по id = %s", id)));
    }

    public Long deleteExam(Long id) {
        return wrap(() -> {
            examService.deleteById(id);
            return 1L;
        });
    }

    private Long saveAndReturnId(ExamDto examDto, Supplier<Exam> builder) {
        return wrap(() -> {
            checkField(examDto.getSchoolClass(), schoolClassService, "Класс не найден");
            checkField(examDto.getSubject(), subjectService, "Предмет не найден");
            return examService.saveAndReturnId(builder.get());
        });
    }

}
