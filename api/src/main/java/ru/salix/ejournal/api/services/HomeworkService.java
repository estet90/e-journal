package ru.salix.ejournal.api.services;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.entities.Homework;
import ru.salix.ejournal.api.repositories.HomeworkRepository;

@Service
public class HomeworkService extends BaseService<Homework, HomeworkRepository> {

    public HomeworkService(HomeworkRepository repository) {
        super(repository);
    }

}
