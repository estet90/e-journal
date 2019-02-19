package ru.salix.ejournal.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.salix.ejournal.api.model.api.ExamDto;
import ru.salix.ejournal.api.model.api.ExamMarkDto;
import ru.salix.ejournal.api.model.api.PupilDto;
import ru.salix.ejournal.api.model.dao.Exam;
import ru.salix.ejournal.api.model.dao.ExamMark;
import ru.salix.ejournal.api.model.dao.Pupil;

@Mapper(componentModel = "spring")
public interface ExamMarkMapper {

    PupilMapper pupilMapper = new PupilMapperImpl();
    ExamMapper examMapper = new ExamMapperImpl();

    @Mappings({
            @Mapping(target = "pupil", ignore = true),
            @Mapping(target = "exam", ignore = true)
    })
    ExamMark fromDto(ExamMarkDto examMarkDto);

    @Mappings({
            @Mapping(target = "pupil", qualifiedByName = "pupilDtoToPupil"),
            @Mapping(target = "exam", qualifiedByName = "examDtoToExam")
    })
    ExamMark fromDtoWithRelatedObjects(ExamMarkDto examMarkDto);

    @Mappings({
            @Mapping(target = "pupil", ignore = true),
            @Mapping(target = "exam", ignore = true)
    })
    ExamMarkDto toDto(ExamMark examMark);

    @Mappings({
            @Mapping(target = "pupil", qualifiedByName = "pupilToPupilDto"),
            @Mapping(target = "exam", qualifiedByName = "examToExamDto")
    })
    ExamMarkDto toDtoWithRelatedObjects(ExamMark examMark);

    default Pupil pupilDtoToPupil(PupilDto pupil) {
        return pupilMapper.pupilDtoToPupil(pupil);
    }

    default PupilDto pupilToPupilDto(Pupil pupil) {
        return pupilMapper.pupilToPupilDto(pupil);
    }

    default Exam examDtoToExam(ExamDto exam) {
        return examMapper.fromDto(exam);
    }

    default ExamDto examToExamDto(Exam exam) {
        return examMapper.toDto(exam);
    }

}
