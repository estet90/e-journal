package ru.salix.ejournal.api.dao.services;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.entities.ExamMark;
import ru.salix.ejournal.api.dao.repositories.ExamMarkRepository;

@Service
public class ExamMarkService extends BaseService<ExamMark, ExamMarkRepository> {

    public ExamMarkService(ExamMarkRepository repository) {
        super(repository);
    }

}
