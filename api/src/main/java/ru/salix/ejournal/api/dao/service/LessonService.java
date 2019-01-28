package ru.salix.ejournal.api.dao.service;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.model.dao.Lesson;
import ru.salix.ejournal.api.dao.repository.LessonRepository;

@Service
public class LessonService extends BaseService<Lesson, LessonRepository> {

    public LessonService(LessonRepository repository) {
        super(repository);
    }

}
