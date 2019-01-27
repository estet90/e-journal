package ru.salix.ejournal.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.salix.ejournal.api.controller.dto.MarkDto;
import ru.salix.ejournal.api.entity.Mark;

@Mapper(componentModel = "spring")
public interface MarkMapper {

    @Mapping(target = "pupil", ignore = true)
    Mark markDtoToMark(MarkDto markDto);

    @Mapping(target = "pupil", ignore = true)
    MarkDto markToMarkDto(Mark mark);

}
