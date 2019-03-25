package ru.salix.ejournal.api.controller.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.builder.api.PeriodTypeDtoBuilder;
import ru.salix.ejournal.api.dao.service.PeriodTypeService;
import ru.salix.ejournal.api.model.api.PeriodTypeDto;
import ru.salix.ejournal.api.model.api.filter.PeriodTypeFilterDto;

import java.util.List;

import static ru.salix.ejournal.api.helper.OperationHelper.wrap;

@Component
@RequiredArgsConstructor
public class PeriodTypeControllerHandler {

    private final PeriodTypeDtoBuilder periodTypeDtoBuilder;
    private final PeriodTypeService periodTypeService;

    public List<PeriodTypeDto> findPeriodTypes() {
        return wrap(() -> periodTypeDtoBuilder.buildList(periodTypeService::findAll));
    }

    public PeriodTypeDto findPeriodTypeById(Long id) {
        return wrap(() -> periodTypeDtoBuilder.buildWithRelatedObjects(periodTypeService.findById(id)));
    }

    public List<PeriodTypeDto> filter(PeriodTypeFilterDto filter) {
        return wrap(() -> periodTypeDtoBuilder.buildList(periodTypeService.filter(filter)));
    }

}
