package ru.salix.ejournal.api.dao.service;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.model.dao.PeriodType;
import ru.salix.ejournal.api.dao.repository.PeriodTypeRepository;

@Service
public class PeriodTypeService extends BaseService<PeriodType, PeriodTypeRepository> {

    public PeriodTypeService(PeriodTypeRepository repository) {
        super(repository);
    }

}
