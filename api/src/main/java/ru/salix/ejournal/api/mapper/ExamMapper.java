package ru.salix.ejournal.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.salix.ejournal.api.controller.dto.ExamDto;
import ru.salix.ejournal.api.entity.Exam;

@Mapper(componentModel = "spring")
public interface ExamMapper {

    @Mappings({
            @Mapping(target = "subject", ignore = true),
            @Mapping(target = "schoolClass", ignore = true)
    })
    Exam examDtoToExam(ExamDto examDto);

    @Mappings({
            @Mapping(target = "subject", ignore = true),
            @Mapping(target = "schoolClass", ignore = true)
    })
    ExamDto examToExamDto(Exam exam);

}
