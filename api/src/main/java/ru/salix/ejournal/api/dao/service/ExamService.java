package ru.salix.ejournal.api.dao.service;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.entity.Exam;
import ru.salix.ejournal.api.dao.repository.ExamRepository;

@Service
public class ExamService extends BaseService<Exam, ExamRepository> {

    public ExamService(ExamRepository repository) {
        super(repository);
    }

}
