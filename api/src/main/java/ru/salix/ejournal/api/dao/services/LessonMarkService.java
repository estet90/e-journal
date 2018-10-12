package ru.salix.ejournal.api.dao.services;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.entities.LessonMark;
import ru.salix.ejournal.api.dao.repositories.LessonMarkRepository;

@Service
public class LessonMarkService extends BaseService<LessonMark, LessonMarkRepository> {

    public LessonMarkService(LessonMarkRepository repository) {
        super(repository);
    }

}
