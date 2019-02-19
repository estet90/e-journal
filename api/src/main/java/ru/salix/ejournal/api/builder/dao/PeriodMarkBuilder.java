package ru.salix.ejournal.api.builder.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.PeriodMarkMapper;
import ru.salix.ejournal.api.model.api.PeriodMarkDto;
import ru.salix.ejournal.api.model.dao.PeriodMark;

@Component
@RequiredArgsConstructor
public class PeriodMarkBuilder extends AbstractDaoBuilder<PeriodMark, PeriodMarkDto> {

    private final PeriodMarkMapper periodMarkMapper;

    private final SubjectBuilder subjectBuilder;
    private final PeriodBuilder periodBuilder;

    @Override
    public PeriodMark build(PeriodMarkDto periodMarkDto) {
        return periodMarkMapper.fromDto(periodMarkDto);
    }

    @Override
    public PeriodMark buildWithRelatedObjects(PeriodMarkDto periodMarkDto) {
        var periodMark = build(periodMarkDto);
        periodMark.setPeriod(periodBuilder.build(periodMarkDto.getPeriod()));
        periodMark.setSubject(subjectBuilder.build(periodMarkDto.getSubject()));
        return periodMark;
    }

}
