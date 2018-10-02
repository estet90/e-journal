package ru.salix.ejournal.api.services;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.entities.PeriodType;
import ru.salix.ejournal.api.repositories.PeriodTypeRepository;

@Service
public class PeriodTypeService extends BaseService<PeriodType, PeriodTypeRepository> {

    public PeriodTypeService(PeriodTypeRepository repository) {
        super(repository);
    }

}
