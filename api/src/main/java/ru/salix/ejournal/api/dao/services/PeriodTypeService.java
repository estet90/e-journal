package ru.salix.ejournal.api.dao.services;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.entities.PeriodType;
import ru.salix.ejournal.api.dao.repositories.PeriodTypeRepository;

@Service
public class PeriodTypeService extends BaseService<PeriodType, PeriodTypeRepository> {

    public PeriodTypeService(PeriodTypeRepository repository) {
        super(repository);
    }

}
