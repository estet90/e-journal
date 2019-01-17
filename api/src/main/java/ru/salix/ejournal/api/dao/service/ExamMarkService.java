package ru.salix.ejournal.api.dao.service;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.entity.ExamMark;
import ru.salix.ejournal.api.dao.repository.ExamMarkRepository;

@Service
public class ExamMarkService extends BaseService<ExamMark, ExamMarkRepository> {

    public ExamMarkService(ExamMarkRepository repository) {
        super(repository);
    }

}
