package ru.salix.ejournal.api.builder.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.PeriodMarkMapper;
import ru.salix.ejournal.api.model.api.PeriodMarkDto;
import ru.salix.ejournal.api.model.dao.PeriodMark;

@Component
@RequiredArgsConstructor
public class PeriodMarkDtoBuilder extends AbstractDtoBuilder<PeriodMarkDto, PeriodMark> {

    private final PeriodMarkMapper periodMarkMapper;

    private final SubjectDtoBuilder subjectDtoBuilder;
    private final PeriodDtoBuilder periodDtoBuilder;

    @Override
    public PeriodMarkDto build(PeriodMark periodMark) {
        return periodMarkMapper.periodMarkToPeriodMarkDto(periodMark);
    }

    @Override
    public PeriodMarkDto buildWithRelatedObjects(PeriodMark periodMark) {
        var periodMarkDto = build(periodMark);
        periodMarkDto.setPeriod(periodDtoBuilder.build(periodMark.getPeriod()));
        periodMarkDto.setSubject(subjectDtoBuilder.build(periodMark.getSubject()));
        return periodMarkDto;
    }

}
