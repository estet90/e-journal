package ru.salix.ejournal.api.controller.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.builder.dao.ExamBuilder;
import ru.salix.ejournal.api.builder.dto.ExamDtoBuilder;
import ru.salix.ejournal.api.controller.dto.ExamDto;
import ru.salix.ejournal.api.controller.dto.ExamFilterDto;
import ru.salix.ejournal.api.controller.dto.SchoolClassDto;
import ru.salix.ejournal.api.controller.dto.SubjectDto;
import ru.salix.ejournal.api.dao.service.ExamService;
import ru.salix.ejournal.api.dao.service.SchoolClassService;
import ru.salix.ejournal.api.dao.service.SubjectService;
import ru.salix.ejournal.api.entity.Exam;

import java.util.List;
import java.util.function.Supplier;

import static java.util.Optional.ofNullable;
import static ru.salix.ejournal.api.helper.ExceptionHelper.notFoundInDbException;
import static ru.salix.ejournal.api.helper.OperationWrapper.wrap;

@Component
@RequiredArgsConstructor
public class ExamControllerHandler {

    private final ExamService examService;
    private final ExamDtoBuilder examDtoBuilder;
    private final ExamBuilder examBuilder;

    private final SubjectService subjectService;

    private final SchoolClassService schoolClassService;

    public List<ExamDto> findExams() {
        return wrap(() -> examDtoList(examService::findAll));
    }

    public ExamDto findExamById(Long id) {
        return wrap(() -> examDtoBuilder.build(examService.findById(id)));
    }

    public List<ExamDto> filter(ExamFilterDto filter) {
        return wrap(() -> examDtoList(() -> examService.filter(filter)));
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
            ofNullable(examDto.getSchoolClass())
                    .map(SchoolClassDto::getId)
                    .map(schoolClassService::findById)
                    .orElseThrow(() -> notFoundInDbException("Класс не найден"));
            ofNullable(examDto.getSubject())
                    .map(SubjectDto::getId)
                    .map(subjectService::findById)
                    .orElseThrow(() -> notFoundInDbException("Предмет не найден"));
            return examService.saveAndReturnId(builder.get());
        });
    }

    private List<ExamDto> examDtoList(Supplier<List<Exam>> supplier) {
        return wrap(() -> examDtoBuilder.buildList(supplier.get()));
    }

}
