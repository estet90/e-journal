package ru.salix.ejournal.api.dao.service;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.dao.repository.LessonMarkRepository;
import ru.salix.ejournal.api.dao.specification.LessonMarkSpecifications;
import ru.salix.ejournal.api.model.api.filter.LessonMarkFilterDto;
import ru.salix.ejournal.api.model.dao.LessonMark;

import java.util.List;

@Service
public class LessonMarkService extends BaseService<LessonMark, LessonMarkRepository> {

    private final LessonMarkSpecifications lessonMarkSpecifications;

    public LessonMarkService(LessonMarkRepository repository, LessonMarkSpecifications lessonMarkSpecifications) {
        super(repository);
        this.lessonMarkSpecifications = lessonMarkSpecifications;
    }

    public List<LessonMark> filter(LessonMarkFilterDto filter) {
        return filter(lessonMarkSpecifications.filterSpecification(filter));
    }

}
