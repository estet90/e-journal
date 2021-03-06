package ru.salix.ejournal.api.dao.service;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.model.api.filter.ExamFilterDto;
import ru.salix.ejournal.api.dao.specification.ExamSpecifications;
import ru.salix.ejournal.api.model.dao.Exam;
import ru.salix.ejournal.api.dao.repository.ExamRepository;

import java.util.List;

@Service
public class ExamService extends BaseService<Exam, ExamRepository> {

    private final ExamSpecifications examSpecifications;

    public ExamService(ExamRepository repository, ExamSpecifications examSpecifications) {
        super(repository);
        this.examSpecifications = examSpecifications;
    }

    public List<Exam> filter(ExamFilterDto filter) {
        return filter(examSpecifications.filterSpecification(filter));
    }

}
