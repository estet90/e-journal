package ru.salix.ejournal.api.builder.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.controller.dto.MarkDto;
import ru.salix.ejournal.api.entity.Mark;
import ru.salix.ejournal.api.mapper.MarkMapper;

@Component
@RequiredArgsConstructor
public class MarkDtoBuilder extends AbstractDtoBuilder<MarkDto, Mark> {

    private final MarkMapper markMapper;

    @Override
    public MarkDto build(Mark mark) {
        return markMapper.markToMarkDto(mark);
    }

    @Override
    public MarkDto buildWithRelatedObjects(Mark entity) {
        return null;
    }

}
