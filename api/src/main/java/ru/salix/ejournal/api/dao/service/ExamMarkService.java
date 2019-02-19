package ru.salix.ejournal.api.dao.service;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.dao.repository.ExamMarkRepository;
import ru.salix.ejournal.api.dao.specification.ExamMarkSpecifications;
import ru.salix.ejournal.api.model.api.filter.ExamMarkFilterDto;
import ru.salix.ejournal.api.model.dao.ExamMark;

import java.util.List;

@Service
public class ExamMarkService extends BaseService<ExamMark, ExamMarkRepository> {

    private final ExamMarkSpecifications examMarkSpecifications;

    public ExamMarkService(ExamMarkRepository repository, ExamMarkSpecifications examMarkSpecifications) {
        super(repository);
        this.examMarkSpecifications = examMarkSpecifications;
    }

    public List<ExamMark> filter(ExamMarkFilterDto filter) {
        return filter(examMarkSpecifications.filterSpecification(filter));
    }

}
