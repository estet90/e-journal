package ru.salix.ejournal.api.services;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.entities.Period;
import ru.salix.ejournal.api.repositories.PeriodRepository;

@Service
public class PeriodService extends BaseService<Period, PeriodRepository> {

    public PeriodService(PeriodRepository repository) {
        super(repository);
    }

}
