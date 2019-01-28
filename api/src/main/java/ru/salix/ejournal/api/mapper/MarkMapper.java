package ru.salix.ejournal.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.salix.ejournal.api.model.api.MarkDto;
import ru.salix.ejournal.api.model.dao.Mark;

@Mapper(componentModel = "spring")
public interface MarkMapper {

    @Mapping(target = "pupil", ignore = true)
    Mark markDtoToMark(MarkDto markDto);

    @Mapping(target = "pupil", ignore = true)
    MarkDto markToMarkDto(Mark mark);

}
