package ru.salix.ejournal.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.salix.ejournal.api.model.api.TestDto;
import ru.salix.ejournal.api.model.dao.Test;

@Mapper(componentModel = "spring")
public interface TestMapper {

    @Mapping(target = "lesson", ignore = true)
    Test testDtoToTest(TestDto testDto);

    @Mapping(target = "lesson", ignore = true)
    TestDto testToTestDto(Test test);

}
