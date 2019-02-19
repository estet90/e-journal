package ru.salix.ejournal.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.salix.ejournal.api.model.api.SchoolClassDto;
import ru.salix.ejournal.api.model.dao.SchoolClass;

@Mapper(
        componentModel = "spring",
        uses = {
                TeacherMapper.class,
                PeriodMapper.class,
                TimetableMapper.class,
                PupilMapper.class
        }
)
public interface SchoolClassMapper extends BaseMapper<SchoolClass, SchoolClassDto> {

    @Mappings({
            @Mapping(target = "teacher", ignore = true),
            @Mapping(target = "period", ignore = true),
            @Mapping(target = "timetables", ignore = true),
            @Mapping(target = "pupils", ignore = true)
    })
    @FromDto
    SchoolClass fromDto(SchoolClassDto schoolClassDto);

    @Mappings({
            @Mapping(target = "teacher", qualifiedBy = TeacherMapper.FromDto.class),
            @Mapping(target = "period", qualifiedBy = PeriodMapper.FromDto.class),
            @Mapping(target = "timetables", qualifiedBy = TimetableMapper.FromDtoList.class),
            @Mapping(target = "pupils", qualifiedBy = PupilMapper.FromDtoList.class)
    })
    SchoolClass fromDtoWithRelatedObjects(SchoolClassDto schoolClassDto);

    @Mappings({
            @Mapping(target = "teacher", ignore = true),
            @Mapping(target = "period", ignore = true),
            @Mapping(target = "timetables", ignore = true),
            @Mapping(target = "pupils", ignore = true)
    })
    @ToDto
    SchoolClassDto toDto(SchoolClass schoolClass);

    @Mappings({
            @Mapping(target = "teacher", qualifiedBy = TeacherMapper.ToDto.class),
            @Mapping(target = "period", qualifiedBy = PeriodMapper.ToDto.class),
            @Mapping(target = "timetables", qualifiedBy = TimetableMapper.ToDtoList.class),
            @Mapping(target = "pupils", qualifiedBy = PupilMapper.ToDtoList.class)
    })
    SchoolClassDto toDtoWithRelatedObjects(SchoolClass schoolClass);

}
