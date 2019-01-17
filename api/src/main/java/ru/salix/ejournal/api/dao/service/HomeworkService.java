package ru.salix.ejournal.api.dao.service;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.entity.Homework;
import ru.salix.ejournal.api.dao.repository.HomeworkRepository;

@Service
public class HomeworkService extends BaseService<Homework, HomeworkRepository> {

    public HomeworkService(HomeworkRepository repository) {
        super(repository);
    }

}
