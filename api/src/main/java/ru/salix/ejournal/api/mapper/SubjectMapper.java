package ru.salix.ejournal.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.salix.ejournal.api.model.api.SubjectDto;
import ru.salix.ejournal.api.model.dao.Subject;

@Mapper(componentModel = "spring")
public interface SubjectMapper {

    @Mapping(target = "teachers", ignore = true)
    Subject subjectDtoToSubject(SubjectDto subjectDto);

    @Mapping(target = "teachers", ignore = true)
    SubjectDto subjectToSubjectDto(Subject subject);

}
