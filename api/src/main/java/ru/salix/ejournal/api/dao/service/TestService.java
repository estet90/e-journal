package ru.salix.ejournal.api.dao.service;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.entity.Test;
import ru.salix.ejournal.api.dao.repository.TestRepository;

@Service
public class TestService extends BaseService<Test, TestRepository> {

    public TestService(TestRepository repository) {
        super(repository);
    }

}
