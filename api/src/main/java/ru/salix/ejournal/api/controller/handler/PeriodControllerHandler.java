package ru.salix.ejournal.api.controller.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.builder.api.PeriodDtoBuilder;
import ru.salix.ejournal.api.builder.dao.PeriodBuilder;
import ru.salix.ejournal.api.dao.service.PeriodService;
import ru.salix.ejournal.api.dao.service.PeriodTypeService;
import ru.salix.ejournal.api.model.api.PeriodDto;
import ru.salix.ejournal.api.model.api.filter.PeriodFilterDto;
import ru.salix.ejournal.api.model.dao.Period;

import java.util.List;
import java.util.function.Supplier;

import static java.util.Optional.ofNullable;
import static ru.salix.ejournal.api.helper.ExceptionHelper.notFoundInDbException;
import static ru.salix.ejournal.api.helper.OperationHelper.checkField;
import static ru.salix.ejournal.api.helper.OperationHelper.wrap;

@Component
@RequiredArgsConstructor
public class PeriodControllerHandler {

    private final PeriodDtoBuilder periodDtoBuilder;
    private final PeriodService periodService;
    private final PeriodBuilder periodBuilder;

    private final PeriodTypeService periodTypeService;

    public List<PeriodDto> findPeriods() {
        return wrap(() -> periodDtoBuilder.buildList(periodService::findAll));
    }

    public PeriodDto findPeriodById(Long id) {
        return wrap(() -> periodDtoBuilder.buildWithRelatedObjects(periodService.findById(id)));
    }

    public List<PeriodDto> filter(PeriodFilterDto filter) {
        return wrap(() -> periodDtoBuilder.buildList(periodService.filter(filter)));
    }

    public Long createPeriod(PeriodDto periodDto) {
        return saveAndReturnId(periodDto, () -> periodBuilder.buildWithRelatedObjects(periodDto));
    }

    public Long updatePeriod(PeriodDto periodDto, Long id) {
        return ofNullable(periodService.findById(id))
                .map(period -> saveAndReturnId(periodDto, () -> periodBuilder.buildWithRelatedObjects(periodDto, id)))
                .orElseThrow(() -> notFoundInDbException(String.format("Не найден период по id = %s", id)));
    }

    public Long saveAndReturnId(PeriodDto periodDto, Supplier<Period> builder) {
        return wrap(() -> {
            checkField(periodDto.getPeriodType(), periodTypeService, "Тип периода не найден");
            return periodService.saveAndReturnId(builder.get());
        });
    }

}
