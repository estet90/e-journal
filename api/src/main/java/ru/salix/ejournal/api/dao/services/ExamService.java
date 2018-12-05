package ru.salix.ejournal.api.dao.services;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.entities.Exam;
import ru.salix.ejournal.api.dao.repositories.ExamRepository;

@Service
public class ExamService extends BaseService<Exam, ExamRepository> {

    public ExamService(ExamRepository repository) {
        super(repository);
    }

}