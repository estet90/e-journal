package ru.salix.ejournal.api.dao.service;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.dao.repository.PeriodMarkRepository;
import ru.salix.ejournal.api.dao.specification.PeriodMarkSpecifications;
import ru.salix.ejournal.api.model.api.filter.PeriodMarkFilterDto;
import ru.salix.ejournal.api.model.dao.PeriodMark;

import java.util.List;

@Service
public class PeriodMarkService extends BaseService<PeriodMark, PeriodMarkRepository> {

    private final PeriodMarkSpecifications periodMarkSpecifications;

    public PeriodMarkService(PeriodMarkRepository repository, PeriodMarkSpecifications periodMarkSpecifications) {
        super(repository);
        this.periodMarkSpecifications = periodMarkSpecifications;
    }

    public List<PeriodMark> filter(PeriodMarkFilterDto filter) {
        return filter(periodMarkSpecifications.filterSpecification(filter));
    }

}
