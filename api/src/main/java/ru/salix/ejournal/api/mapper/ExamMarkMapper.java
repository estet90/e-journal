package ru.salix.ejournal.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.salix.ejournal.api.controller.dto.ExamMarkDto;
import ru.salix.ejournal.api.entity.ExamMark;

@Mapper(componentModel = "spring")
public interface ExamMarkMapper {

    @Mappings({
            @Mapping(target = "pupil", ignore = true),
            @Mapping(target = "exam", ignore = true)
    })
    ExamMark examMarkDtoToExamMark(ExamMarkDto examMarkDto);

    @Mappings({
            @Mapping(target = "pupil", ignore = true),
            @Mapping(target = "exam", ignore = true)
    })
    ExamMarkDto examMarkToExamMarkDto(ExamMark examMark);

}
