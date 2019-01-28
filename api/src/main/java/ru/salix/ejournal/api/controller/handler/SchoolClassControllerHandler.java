package ru.salix.ejournal.api.controller.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.builder.dao.SchoolClassBuilder;
import ru.salix.ejournal.api.builder.api.SchoolClassDtoBuilder;
import ru.salix.ejournal.api.model.api.SchoolClassDto;
import ru.salix.ejournal.api.model.api.filter.SchoolClassFilterDto;
import ru.salix.ejournal.api.dao.service.SchoolClassService;

import java.util.List;

import static ru.salix.ejournal.api.helper.OperationWrapper.wrap;

@Component
@RequiredArgsConstructor
public class SchoolClassControllerHandler {

    private final SchoolClassService schoolClassService;
    private final SchoolClassDtoBuilder schoolClassDtoBuilder;
    private final SchoolClassBuilder schoolClassBuilder;

    public List<SchoolClassDto> findClasses() {
        return wrap(() -> schoolClassDtoBuilder.buildList(schoolClassService::findAll));
    }

    public SchoolClassDto findClassById(Long id) {
        return wrap(() -> schoolClassDtoBuilder.build(schoolClassService.findById(id)));
    }

    public List<SchoolClassDto> filter(SchoolClassFilterDto filter) {
        return null;
    }

}
