package ru.salix.ejournal.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.salix.ejournal.api.model.api.ExamMarkDto;
import ru.salix.ejournal.api.model.dao.ExamMark;

@Mapper(
        componentModel = "spring",
        uses = {
                PupilMapper.class,
                ExamMapper.class
        }
)
public interface ExamMarkMapper extends BaseMapper<ExamMark, ExamMarkDto> {

    @Mappings({
            @Mapping(target = "pupil", ignore = true),
            @Mapping(target = "exam", ignore = true)
    })
    @FromDto
    ExamMark fromDto(ExamMarkDto examMarkDto);

    @Mappings({
            @Mapping(target = "pupil", qualifiedBy = PupilMapper.FromDto.class),
            @Mapping(target = "exam", qualifiedBy = ExamMapper.FromDto.class)
    })
    ExamMark fromDtoWithRelatedObjects(ExamMarkDto examMarkDto);

    @Mappings({
            @Mapping(target = "pupil", ignore = true),
            @Mapping(target = "exam", ignore = true)
    })
    @ToDto
    ExamMarkDto toDto(ExamMark examMark);

    @Mappings({
            @Mapping(target = "pupil", qualifiedBy = PupilMapper.ToDto.class),
            @Mapping(target = "exam", qualifiedBy = ExamMapper.ToDto.class)
    })
    ExamMarkDto toDtoWithRelatedObjects(ExamMark examMark);

}
