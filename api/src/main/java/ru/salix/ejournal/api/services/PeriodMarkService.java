package ru.salix.ejournal.api.services;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.entities.PeriodMark;
import ru.salix.ejournal.api.repositories.PeriodMarkRepository;

@Service
public class PeriodMarkService extends BaseService<PeriodMark, PeriodMarkRepository> {

    public PeriodMarkService(PeriodMarkRepository repository) {
        super(repository);
    }

}
