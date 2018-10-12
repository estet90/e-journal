package ru.salix.ejournal.api.dao.services;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.entities.Homework;
import ru.salix.ejournal.api.dao.repositories.HomeworkRepository;

@Service
public class HomeworkService extends BaseService<Homework, HomeworkRepository> {

    public HomeworkService(HomeworkRepository repository) {
        super(repository);
    }

}
