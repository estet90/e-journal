package ru.salix.ejournal.api.controller.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.builder.api.TimetableDtoBuilder;
import ru.salix.ejournal.api.builder.dao.TimetableBuilder;
import ru.salix.ejournal.api.dao.service.TimetableService;
import ru.salix.ejournal.api.model.api.TeacherDto;
import ru.salix.ejournal.api.model.api.TimetableDto;
import ru.salix.ejournal.api.model.api.filter.TimetableFilterDto;

import java.util.List;

import static java.util.Optional.ofNullable;
import static ru.salix.ejournal.api.helper.ExceptionHelper.notFoundInDbException;
import static ru.salix.ejournal.api.helper.OperationWrapper.wrap;

@Component
@RequiredArgsConstructor
public class TimetableControllerHandler {

    private final TimetableService timetableService;
    private final TimetableDtoBuilder timetableDtoBuilder;
    private final TimetableBuilder timetableBuilder;

    public List<TimetableDto> findTimetables() {
        return wrap(() -> timetableDtoBuilder.buildList(timetableService::findAll));
    }

    public TimetableDto findTimetableById(long id) {
        return wrap(() -> {
            var teacher = timetableService.findById(id);
            return timetableDtoBuilder.build(teacher);
        });
    }

    public List<TimetableDto> filter(TimetableFilterDto filter) {
        return wrap(() -> timetableDtoBuilder.buildList(() -> timetableService.filter(filter)));
    }

    public Long createTimetable(TimetableDto timetableDto) {
        return wrap(() -> timetableService.saveAndReturnId(timetableBuilder.build(timetableDto)));
    }

    public Long updateTimetable(TimetableDto timetableDto, Long id) {
        return wrap(() -> ofNullable(timetableService.findById(id))
                .map(teacher -> timetableService.saveAndReturnId(timetableBuilder.build(timetableDto, id)))
                .orElseThrow(() -> notFoundInDbException(String.format("Не найден урок по id = %s", id))));
    }

    public Long deleteTimetable(Long id) {
        return wrap(() -> {
            timetableService.deleteById(id);
            return 1L;
        });
    }

}
