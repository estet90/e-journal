package ru.salix.ejournal.api.controller.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.builder.api.SchoolClassDtoBuilder;
import ru.salix.ejournal.api.builder.dao.SchoolClassBuilder;
import ru.salix.ejournal.api.dao.service.PupilService;
import ru.salix.ejournal.api.dao.service.SchoolClassService;
import ru.salix.ejournal.api.model.api.SchoolClassDto;
import ru.salix.ejournal.api.model.api.filter.SchoolClassFilterDto;

import java.util.List;

import static java.util.Optional.ofNullable;
import static ru.salix.ejournal.api.helper.ExceptionHelper.alreadyExistsInDbException;
import static ru.salix.ejournal.api.helper.ExceptionHelper.notFoundInDbException;
import static ru.salix.ejournal.api.helper.OperationHelper.wrap;

@Component
@RequiredArgsConstructor
public class SchoolClassControllerHandler {

    private final SchoolClassService schoolClassService;
    private final SchoolClassDtoBuilder schoolClassDtoBuilder;
    private final SchoolClassBuilder schoolClassBuilder;

    private final PupilService pupilService;

    public List<SchoolClassDto> findClasses() {
        return wrap(() -> schoolClassDtoBuilder.buildList(schoolClassService::findAll));
    }

    public SchoolClassDto findClassById(Long id) {
        return wrap(() -> schoolClassDtoBuilder.buildWithRelatedObjects(schoolClassService.findById(id)));
    }

    public List<SchoolClassDto> filter(SchoolClassFilterDto filter) {
        return wrap(() -> schoolClassDtoBuilder.buildList(schoolClassService.filter(filter)));
    }

    public Long createClass(SchoolClassDto schoolClassDto) {
        return wrap(() -> schoolClassService.saveAndReturnId(schoolClassBuilder.build(schoolClassDto)));
    }

    public Long updateClass(SchoolClassDto schoolClassDto, Long id) {
        return wrap(() -> ofNullable(schoolClassService.findById(id))
                .map(schoolClass -> schoolClassService.saveAndReturnId(schoolClassBuilder.build(schoolClassDto, id)))
                .orElseThrow(() -> notFoundInDbException(String.format("Не найден класс по id = %s", id))));
    }

    public Long deleteClass(Long id) {
        return wrap(() -> {
            schoolClassService.deleteById(id);
            return 1L;
        });
    }

    public Long addPupilToClass(Long idClass, Long idPupil) {
        return wrap(() -> {
            var pupil = ofNullable(pupilService.findById(idPupil))
                    .orElseThrow(() -> notFoundInDbException(String.format("Не найден ученик по id = %s", idPupil)));
            if (idClass.equals(pupil.getSchoolClass().getId())) {
                throw alreadyExistsInDbException(String.format("Ученик с id = %s уже есть в классе с id = %s", idClass, idPupil));
            }
            var schoolClass = ofNullable(schoolClassService.findById(idClass))
                    .orElseThrow(() -> notFoundInDbException(String.format("Не найден класс по id = %s", idClass)));
            pupil.setSchoolClass(schoolClass);
            pupilService.save(pupil);
            return 1L;
        });
    }

    public Long deletePupilFromClass(Long idClass, Long idPupil) {
        return wrap(() -> {
            ofNullable(schoolClassService.findById(idClass))
                    .orElseThrow(() -> notFoundInDbException(String.format("Не найден класс по id = %s", idClass)));
            var pupil = ofNullable(pupilService.findBySchoolClassIdAndId(idClass, idPupil))
                    .orElseThrow(() -> notFoundInDbException(String.format("Не найден ученик по id = %s в классе с id = %s", idPupil, idClass)));
            pupil.setSchoolClass(null);
            pupilService.save(pupil);
            return 1L;
        });
    }

}
