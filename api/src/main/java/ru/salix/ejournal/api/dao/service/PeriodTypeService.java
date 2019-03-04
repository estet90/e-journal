package ru.salix.ejournal.api.dao.service;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.dao.repository.PeriodTypeRepository;
import ru.salix.ejournal.api.dao.specification.PeriodTypeSpecifications;
import ru.salix.ejournal.api.model.api.filter.PeriodTypeFilterDto;
import ru.salix.ejournal.api.model.dao.PeriodType;

import java.util.List;

@Service
public class PeriodTypeService extends BaseService<PeriodType, PeriodTypeRepository> {

    private final PeriodTypeSpecifications periodTypeSpecifications;

    public PeriodTypeService(PeriodTypeRepository repository, PeriodTypeSpecifications periodTypeSpecifications) {
        super(repository);
        this.periodTypeSpecifications = periodTypeSpecifications;
    }

    public List<PeriodType> filter(PeriodTypeFilterDto filter) {
        return filter(periodTypeSpecifications.filterSpecification(filter));
    }

}
