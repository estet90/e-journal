package ru.salix.ejournal.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.salix.ejournal.api.controller.dto.SubjectDto;
import ru.salix.ejournal.api.entity.Subject;

@Mapper(componentModel = "spring")
public interface SubjectMapper {

    @Mapping(target = "teachers", ignore = true)
    Subject subjectDtoToSubject(SubjectDto subjectDto);

}
