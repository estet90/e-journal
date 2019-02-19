package ru.salix.ejournal.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.salix.ejournal.api.model.api.SubjectDto;
import ru.salix.ejournal.api.model.dao.Subject;

@Mapper(componentModel = "spring", uses = TeacherMapper.class)
public interface SubjectMapper extends BaseMapper<Subject, SubjectDto> {

    @Mapping(target = "teachers", ignore = true)
    @FromDto
    Subject fromDto(SubjectDto subjectDto);

    @Mapping(target = "teachers", qualifiedBy = TeacherMapper.FromDtoList.class)
    Subject fromDtoWithRelatedObjects(SubjectDto subjectDto);

    @Mapping(target = "teachers", ignore = true)
    @ToDto
    SubjectDto toDto(Subject subject);

    @Mapping(target = "teachers", qualifiedBy = TeacherMapper.ToDtoList.class)
    SubjectDto toDtoWithRelatedObjects(Subject subject);

}
