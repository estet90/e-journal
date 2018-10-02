package ru.salix.ejournal.api.services;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.entities.Pupil;
import ru.salix.ejournal.api.repositories.PupilRepository;

@Service
public class PupilService extends BaseService<Pupil, PupilRepository> {

    public PupilService(PupilRepository repository) {
        super(repository);
    }

}
