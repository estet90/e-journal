package ru.salix.ejournal.api.controller.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.builder.api.PupilDtoBuilder;
import ru.salix.ejournal.api.builder.dao.PupilBuilder;
import ru.salix.ejournal.api.dao.service.PupilService;
import ru.salix.ejournal.api.model.api.PupilDto;
import ru.salix.ejournal.api.model.api.filter.PupilFilterDto;

import java.util.List;

import static java.util.Optional.ofNullable;
import static ru.salix.ejournal.api.helper.ExceptionHelper.notFoundInDbException;
import static ru.salix.ejournal.api.helper.OperationHelper.wrap;

@Component
@RequiredArgsConstructor
public class PupilControllerHandler {

    private final PupilService pupilService;
    private final PupilDtoBuilder pupilDtoBuilder;
    private final PupilBuilder pupilBuilder;

    public List<PupilDto> findPupils() {
        return wrap(() -> pupilDtoBuilder.buildList(pupilService::findAll));
    }

    public PupilDto findPupilById(Long id) {
        return wrap(() -> {
            var pupil = pupilService.findById(id);
            return pupilDtoBuilder.build(pupil);
        });
    }

    public List<PupilDto> filter(PupilFilterDto filter) {
        return wrap(() -> pupilDtoBuilder.buildList(() -> pupilService.filter(filter)));
    }

    public Long createPupil(PupilDto pupilDto) {
        return wrap(() -> pupilService.saveAndReturnId(pupilBuilder.build(pupilDto)));
    }

    public Long updatePupil(PupilDto pupilDto, Long id) {
        return wrap(() -> ofNullable(pupilService.findById(id))
                .map(subject -> pupilService.saveAndReturnId(pupilBuilder.build(pupilDto, id)))
                .orElseThrow(() -> notFoundInDbException(String.format("Не найден ученик по id = %s", id))));
    }

    public Long deletePupil(Long id) {
        return wrap(() -> {
            pupilService.deleteById(id);
            return 1L;
        });
    }

}
