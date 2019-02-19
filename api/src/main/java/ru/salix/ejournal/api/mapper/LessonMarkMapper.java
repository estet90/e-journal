package ru.salix.ejournal.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.salix.ejournal.api.model.api.LessonMarkDto;
import ru.salix.ejournal.api.model.dao.LessonMark;

@Mapper(
        componentModel = "spring",
        uses = {
                LessonMapper.class,
                HomeworkMapper.class,
                TestMapper.class,
                PupilMapper.class
        }
)
public interface LessonMarkMapper extends BaseMapper<LessonMark, LessonMarkDto> {

    @Mappings({
            @Mapping(target = "lesson", ignore = true),
            @Mapping(target = "homework", ignore = true),
            @Mapping(target = "test", ignore = true),
            @Mapping(target = "pupil", ignore = true)
    })
    LessonMark fromDto(LessonMarkDto lessonMarkDto);

    @Mappings({
            @Mapping(target = "lesson", qualifiedBy = LessonMapper.FromDto.class),
            @Mapping(target = "homework", qualifiedBy = HomeworkMapper.FromDto.class),
            @Mapping(target = "test", qualifiedBy = TestMapper.FromDto.class),
            @Mapping(target = "pupil", qualifiedBy = PupilMapper.FromDto.class)
    })
    LessonMark fromDtoWithRelatedObjects(LessonMarkDto lessonMarkDto);

    @Mappings({
            @Mapping(target = "lesson", ignore = true),
            @Mapping(target = "homework", ignore = true),
            @Mapping(target = "test", ignore = true),
            @Mapping(target = "pupil", ignore = true)
    })
    LessonMarkDto toDto(LessonMark lessonMark);

    @Mappings({
            @Mapping(target = "lesson", qualifiedBy = LessonMapper.ToDto.class),
            @Mapping(target = "homework", qualifiedBy = HomeworkMapper.ToDto.class),
            @Mapping(target = "test", qualifiedBy = TestMapper.ToDto.class),
            @Mapping(target = "pupil", qualifiedBy = PupilMapper.ToDto.class)
    })
    LessonMarkDto toDtoWithRelatedObjects(LessonMark lessonMark);

}
