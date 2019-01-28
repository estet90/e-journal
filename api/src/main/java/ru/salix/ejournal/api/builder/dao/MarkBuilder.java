package ru.salix.ejournal.api.builder.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.model.api.MarkDto;
import ru.salix.ejournal.api.model.dao.Mark;
import ru.salix.ejournal.api.mapper.MarkMapper;

@Component
@RequiredArgsConstructor
public class MarkBuilder extends AbstractDaoBuilder<Mark, MarkDto> {

    private final MarkMapper markMapper;

    @Override
    public Mark build(MarkDto markDto) {
        return markMapper.markDtoToMark(markDto);
    }

}
