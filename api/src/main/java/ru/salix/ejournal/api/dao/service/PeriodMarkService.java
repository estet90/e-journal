package ru.salix.ejournal.api.dao.service;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.entity.PeriodMark;
import ru.salix.ejournal.api.dao.repository.PeriodMarkRepository;

@Service
public class PeriodMarkService extends BaseService<PeriodMark, PeriodMarkRepository> {

    public PeriodMarkService(PeriodMarkRepository repository) {
        super(repository);
    }

}
