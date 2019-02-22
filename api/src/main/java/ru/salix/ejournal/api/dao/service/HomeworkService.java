package ru.salix.ejournal.api.dao.service;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.dao.repository.HomeworkRepository;
import ru.salix.ejournal.api.dao.specification.HomeworkSpecifications;
import ru.salix.ejournal.api.model.api.filter.HomeworkFilterDto;
import ru.salix.ejournal.api.model.dao.Homework;

import java.util.List;

@Service
public class HomeworkService extends BaseService<Homework, HomeworkRepository> {

    private final HomeworkSpecifications homeworkSpecifications;

    public HomeworkService(HomeworkRepository repository, HomeworkSpecifications homeworkSpecifications) {
        super(repository);
        this.homeworkSpecifications = homeworkSpecifications;
    }

    public List<Homework> filter(HomeworkFilterDto filter) {
        return filter(homeworkSpecifications.filterSpecification(filter));
    }

}
