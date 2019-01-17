package ru.salix.ejournal.api.dao.service;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.entity.Period;
import ru.salix.ejournal.api.dao.repository.PeriodRepository;

@Service
public class PeriodService extends BaseService<Period, PeriodRepository> {

    public PeriodService(PeriodRepository repository) {
        super(repository);
    }

}
