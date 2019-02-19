package ru.salix.ejournal.api.controller.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.builder.api.PeriodMarkDtoBuilder;
import ru.salix.ejournal.api.builder.dao.PeriodMarkBuilder;
import ru.salix.ejournal.api.dao.service.PeriodMarkService;
import ru.salix.ejournal.api.dao.service.PeriodService;
import ru.salix.ejournal.api.dao.service.PupilService;
import ru.salix.ejournal.api.dao.service.SubjectService;
import ru.salix.ejournal.api.model.api.PeriodMarkDto;
import ru.salix.ejournal.api.model.api.filter.PeriodMarkFilterDto;
import ru.salix.ejournal.api.model.dao.PeriodMark;

import java.util.List;
import java.util.function.Supplier;

import static java.util.Optional.ofNullable;
import static ru.salix.ejournal.api.helper.ExceptionHelper.notFoundInDbException;
import static ru.salix.ejournal.api.helper.OperationHelper.checkField;
import static ru.salix.ejournal.api.helper.OperationHelper.wrap;

@Component
@RequiredArgsConstructor
public class PeriodMarkControllerHandler {

    private final PeriodMarkDtoBuilder periodMarkDtoBuilder;
    private final PeriodMarkService periodMarkService;
    private final PeriodMarkBuilder periodMarkBuilder;

    private final PupilService pupilService;
    private final PeriodService periodService;
    private final SubjectService subjectService;

    public List<PeriodMarkDto> findPeriodMarks() {
        return wrap(() -> periodMarkDtoBuilder.buildList(periodMarkService::findAll));
    }

    public PeriodMarkDto findPeriodMarkById(Long id) {
        return wrap(() -> periodMarkDtoBuilder.build(periodMarkService.findById(id)));
    }

    public List<PeriodMarkDto> filter(PeriodMarkFilterDto filter) {
        return wrap(() -> periodMarkDtoBuilder.buildList(() -> periodMarkService.filter(filter)));
    }

    public Long createPeriodMark(PeriodMarkDto periodMarkDto) {
        return saveAndReturnId(periodMarkDto, () -> periodMarkBuilder.buildWithRelatedObjects(periodMarkDto));
    }

    public Long updatePeriodMark(PeriodMarkDto periodMarkDto, Long id) {
        return ofNullable(periodMarkService.findById(id))
                .map(exam -> saveAndReturnId(periodMarkDto, () -> periodMarkBuilder.buildWithRelatedObjects(periodMarkDto, id)))
                .orElseThrow(() -> notFoundInDbException(String.format("Не найдена оценка по id = %s", id)));
    }

    public Long deletePeriodMark(Long id) {
        return wrap(() -> {
            periodMarkService.deleteById(id);
            return 1L;
        });
    }

    private Long saveAndReturnId(PeriodMarkDto periodMarkDto, Supplier<PeriodMark> builder) {
        return wrap(() -> {
            checkField(periodMarkDto.getPupil(), pupilService, "Ученик не найден");
            checkField(periodMarkDto.getPeriod(), periodService, "Учебный период не найден");
            checkField(periodMarkDto.getSubject(), subjectService, "Предмет не найден");
            return periodMarkService.saveAndReturnId(builder.get());
        });
    }

}
