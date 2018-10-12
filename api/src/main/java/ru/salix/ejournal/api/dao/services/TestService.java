package ru.salix.ejournal.api.dao.services;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.entities.Test;
import ru.salix.ejournal.api.dao.repositories.TestRepository;

@Service
public class TestService extends BaseService<Test, TestRepository> {

    public TestService(TestRepository repository) {
        super(repository);
    }

}
