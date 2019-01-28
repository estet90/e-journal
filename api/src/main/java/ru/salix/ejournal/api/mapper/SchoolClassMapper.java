package ru.salix.ejournal.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.salix.ejournal.api.model.api.SchoolClassDto;
import ru.salix.ejournal.api.model.dao.SchoolClass;

@Mapper(componentModel = "spring")
public interface SchoolClassMapper {

    @Mappings({
            @Mapping(target = "teacher", ignore = true),
            @Mapping(target = "period", ignore = true),
            @Mapping(target = "timetables", ignore = true),
            @Mapping(target = "pupils", ignore = true)
    })
    SchoolClass schoolClassDtoToSchoolClass(SchoolClassDto schoolClassDto);

    @Mappings({
            @Mapping(target = "teacher", ignore = true),
            @Mapping(target = "period", ignore = true),
            @Mapping(target = "timetables", ignore = true),
            @Mapping(target = "pupils", ignore = true)
    })
    SchoolClassDto schoolClassToSchoolClassDto(SchoolClass schoolClass);

}
