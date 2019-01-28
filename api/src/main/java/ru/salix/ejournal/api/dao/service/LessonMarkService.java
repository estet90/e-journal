package ru.salix.ejournal.api.dao.service;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.model.dao.LessonMark;
import ru.salix.ejournal.api.dao.repository.LessonMarkRepository;

@Service
public class LessonMarkService extends BaseService<LessonMark, LessonMarkRepository> {

    public LessonMarkService(LessonMarkRepository repository) {
        super(repository);
    }

}
