package ru.salix.ejournal.api.dao.service;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.dao.repository.TestRepository;
import ru.salix.ejournal.api.dao.specification.TestFilterSpecifications;
import ru.salix.ejournal.api.model.api.filter.TestFilterDto;
import ru.salix.ejournal.api.model.dao.Test;

import java.util.List;

@Service
public class TestService extends BaseService<Test, TestRepository> {

    private final TestFilterSpecifications testFilterSpecifications;

    public TestService(TestRepository repository, TestFilterSpecifications testFilterSpecifications) {
        super(repository);
        this.testFilterSpecifications = testFilterSpecifications;
    }

    public List<Test> filter(TestFilterDto filter) {
        return filter(testFilterSpecifications.filterSpecification(filter));
    }

}
