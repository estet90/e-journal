package ru.salix.ejournal.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.salix.ejournal.api.model.api.TimetableDto;
import ru.salix.ejournal.api.model.dao.Timetable;

@Mapper(
        componentModel = "spring",
        uses = {
                SubjectMapper.class,
                SchoolClassMapper.class,
                TeacherMapper.class,
                LessonPeriodMapper.class,
                PeriodMapper.class
        }
)
public interface TimetableMapper extends BaseMapper<Timetable, TimetableDto> {

    @Mappings({
            @Mapping(target = "subject", ignore = true),
            @Mapping(target = "schoolClass", ignore = true),
            @Mapping(target = "teacher", ignore = true),
            @Mapping(target = "lessonPeriod", ignore = true),
            @Mapping(target = "period", ignore = true)
    })
    @FromDto
    Timetable fromDto(TimetableDto timetableDto);

    @Mappings({
            @Mapping(target = "subject", qualifiedBy = SubjectMapper.FromDto.class),
            @Mapping(target = "schoolClass", qualifiedBy = SchoolClassMapper.FromDto.class),
            @Mapping(target = "teacher", qualifiedBy = TeacherMapper.FromDto.class),
            @Mapping(target = "lessonPeriod", qualifiedBy = LessonPeriodMapper.FromDto.class),
            @Mapping(target = "period", qualifiedBy = PeriodMapper.FromDto.class)
    })
    Timetable fromDtoWithRelatedObjects(TimetableDto timetableDto);

    @Mappings({
            @Mapping(target = "subject", ignore = true),
            @Mapping(target = "schoolClass", ignore = true),
            @Mapping(target = "teacher", ignore = true),
            @Mapping(target = "lessonPeriod", ignore = true),
            @Mapping(target = "period", ignore = true)
    })
    @ToDto
    TimetableDto toDto(Timetable timetable);

    @Mappings({
            @Mapping(target = "subject", qualifiedBy = SubjectMapper.ToDto.class),
            @Mapping(target = "schoolClass", qualifiedBy = SchoolClassMapper.ToDto.class),
            @Mapping(target = "teacher", qualifiedBy = TeacherMapper.ToDto.class),
            @Mapping(target = "lessonPeriod", qualifiedBy = LessonPeriodMapper.ToDto.class),
            @Mapping(target = "period", qualifiedBy = PeriodMapper.ToDto.class)
    })
    TimetableDto toDtoWithRelatedObjects(Timetable timetable);

}
