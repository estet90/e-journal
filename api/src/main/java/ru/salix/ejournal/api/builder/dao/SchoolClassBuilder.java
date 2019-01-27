package ru.salix.ejournal.api.builder.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.controller.dto.SchoolClassDto;
import ru.salix.ejournal.api.entity.SchoolClass;
import ru.salix.ejournal.api.mapper.SchoolClassMapper;

@Component
@RequiredArgsConstructor
public class SchoolClassBuilder extends AbstractDaoBuilder<SchoolClass, SchoolClassDto> {

    private final SchoolClassMapper schoolClassMapper;

    @Override
    public SchoolClass build(SchoolClassDto schoolClassDto) {
        return schoolClassMapper.schoolClassDtoToSchoolClass(schoolClassDto);
    }

}
