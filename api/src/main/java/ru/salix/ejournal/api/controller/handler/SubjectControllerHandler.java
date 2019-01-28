package ru.salix.ejournal.api.controller.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.builder.dao.SubjectBuilder;
import ru.salix.ejournal.api.builder.api.SubjectDtoBuilder;
import ru.salix.ejournal.api.model.api.SubjectDto;
import ru.salix.ejournal.api.model.api.filter.SubjectFilterDto;
import ru.salix.ejournal.api.dao.service.SubjectService;
import ru.salix.ejournal.api.model.dao.Subject;

import java.util.List;
import java.util.function.Supplier;

import static java.util.Optional.ofNullable;
import static ru.salix.ejournal.api.helper.ExceptionHelper.notFoundInDbException;
import static ru.salix.ejournal.api.helper.OperationWrapper.wrap;

@Component
@RequiredArgsConstructor
public class SubjectControllerHandler {

    private final SubjectService subjectService;
    private final SubjectDtoBuilder subjectDtoBuilder;
    private final SubjectBuilder subjectBuilder;

    public List<SubjectDto> findSubjects() {
        return subjectDtoList(subjectService::findAll);
    }

    public SubjectDto findSubjectById(Long id) {
        return wrap(() -> subjectDtoBuilder.build(subjectService.findById(id)));
    }

    public List<SubjectDto> filter(SubjectFilterDto filter) {
        return subjectDtoList(() -> subjectService.filter(filter));
    }

    public Long createSubject(SubjectDto subjectDto) {
        return wrap(() -> subjectService.saveAndReturnId(subjectBuilder.build(subjectDto)));
    }

    public Long updateSubject(SubjectDto subjectDto, Long id) {
        return wrap(() -> ofNullable(subjectService.findById(id))
                .map(subject -> subjectService.saveAndReturnId(subjectBuilder.build(subjectDto, id)))
                .orElseThrow(() -> notFoundInDbException(String.format("Не найден предмет по id = %s", id))));
    }

    public Long deleteSubject(Long id) {
        return wrap(() -> {
           subjectService.deleteById(id);
           return 1L;
        });
    }

    private List<SubjectDto> subjectDtoList(Supplier<List<Subject>> supplier) {
        return wrap(() -> subjectDtoBuilder.buildList(supplier.get()));
    }

}
