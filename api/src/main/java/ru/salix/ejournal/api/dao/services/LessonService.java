package ru.salix.ejournal.api.dao.services;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.entities.Lesson;
import ru.salix.ejournal.api.dao.repositories.LessonRepository;

@Service
public class LessonService extends BaseService<Lesson, LessonRepository> {

    public LessonService(LessonRepository repository) {
        super(repository);
    }

}
