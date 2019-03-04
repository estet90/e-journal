package ru.salix.ejournal.api.dao.service;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.dao.repository.PeriodRepository;
import ru.salix.ejournal.api.dao.specification.PeriodSpecifications;
import ru.salix.ejournal.api.model.api.filter.PeriodFilterDto;
import ru.salix.ejournal.api.model.dao.Period;

import java.util.List;

@Service
public class PeriodService extends BaseService<Period, PeriodRepository> {

    private final PeriodSpecifications periodSpecifications;

    public PeriodService(PeriodRepository repository, PeriodSpecifications periodSpecifications) {
        super(repository);
        this.periodSpecifications = periodSpecifications;
    }

    public List<Period> filter(PeriodFilterDto filter) {
        return filter(periodSpecifications.filter(filter));
    }

}
