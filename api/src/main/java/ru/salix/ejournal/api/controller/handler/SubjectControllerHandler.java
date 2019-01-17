package ru.salix.ejournal.api.controller.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.controller.builder.SubjectDtoBuilder;
import ru.salix.ejournal.api.controller.dto.SubjectDto;
import ru.salix.ejournal.api.controller.dto.SubjectFilterDto;
import ru.salix.ejournal.api.dao.service.SubjectService;
import ru.salix.ejournal.api.entity.Subject;
import ru.salix.ejournal.api.mapper.SubjectMapper;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static ru.salix.ejournal.api.helper.OperationWrapper.wrap;

@Component
@RequiredArgsConstructor
public class SubjectControllerHandler {

    private final SubjectService subjectService;
    private final SubjectDtoBuilder subjectDtoBuilder;

    private final SubjectMapper subjectMapper;

    public List<SubjectDto> findSubjects() {
        return wrap(() -> {
            var subjects = subjectService.findAll();
            return subjectDtoList(subjects);
        });
    }

    public SubjectDto findSubjectById(Long id) {
        return wrap(() -> {
            var subject = subjectService.findById(id);
            return subjectDtoBuilder.build(subject);
        });
    }

    public List<SubjectDto> filter(SubjectFilterDto filter) {
        return wrap(() -> {
            var subjects = subjectService.filter(filter);
            return subjectDtoList(subjects);
        });
    }

    public Long createSubject(SubjectDto subjectDto) {
        return wrap(() -> {
            var subject = subjectMapper.subjectDtoToSubject(subjectDto);
            subject = subjectService.save(subject);
            return subject.getId();
        });
    }

    private List<SubjectDto> subjectDtoList(List<Subject> subjects) {
        return subjects
                .stream()
                .map(subjectDtoBuilder::build)
                .collect(toList());
    }

}
