package ru.salix.ejournal.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.salix.ejournal.api.model.api.TestDto;
import ru.salix.ejournal.api.model.dao.Test;

@Mapper(componentModel = "spring", uses = LessonMapper.class)
public interface TestMapper extends BaseMapper<Test, TestDto> {

    @Mapping(target = "lesson", ignore = true)
    @FromDto
    Test fromDto(TestDto testDto);

    @Mapping(target = "lesson", qualifiedBy = LessonMapper.FromDto.class)
    Test fromDtoWithRelatedObjects(TestDto testDto);

    @Mapping(target = "lesson", ignore = true)
    @ToDto
    TestDto toDto(Test test);

    @Mapping(target = "lesson", qualifiedBy = LessonMapper.ToDto.class)
    TestDto toDtoWithRelatedObjects(Test test);

}
