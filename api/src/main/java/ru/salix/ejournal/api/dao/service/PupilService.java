package ru.salix.ejournal.api.dao.service;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.entity.Pupil;
import ru.salix.ejournal.api.dao.repository.PupilRepository;

@Service
public class PupilService extends BaseService<Pupil, PupilRepository> {

    public PupilService(PupilRepository repository) {
        super(repository);
    }

}
