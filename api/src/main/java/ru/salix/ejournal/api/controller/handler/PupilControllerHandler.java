package ru.salix.ejournal.api.controller.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.builder.dao.PupilBuilder;
import ru.salix.ejournal.api.builder.dto.PupilDtoBuilder;
import ru.salix.ejournal.api.controller.dto.PupilDto;
import ru.salix.ejournal.api.controller.dto.PupilFilterDto;
import ru.salix.ejournal.api.dao.service.PupilService;
import ru.salix.ejournal.api.entity.Pupil;

import java.util.List;
import java.util.function.Supplier;

import static java.util.Optional.ofNullable;
import static ru.salix.ejournal.api.helper.ExceptionHelper.notFoundInDbException;
import static ru.salix.ejournal.api.helper.OperationWrapper.wrap;

@Component
@RequiredArgsConstructor
public class PupilControllerHandler {

    private final PupilService pupilService;
    private final PupilDtoBuilder pupilDtoBuilder;
    private final PupilBuilder pupilBuilder;

    public List<PupilDto> findPupils() {
        return pupilDtoList(pupilService::findAll);
    }

    public PupilDto findPupilById(Long id) {
        return wrap(() -> {
            var pupil = pupilService.findById(id);
            return pupilDtoBuilder.build(pupil);
        });
    }

    public List<PupilDto> filter(PupilFilterDto filter) {
        return pupilDtoList(() -> pupilService.filter(filter));
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

    private List<PupilDto> pupilDtoList(Supplier<List<Pupil>> supplier) {
        return wrap(() -> pupilDtoBuilder.buildList(supplier.get()));
    }

}
