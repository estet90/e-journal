package ru.salix.ejournal.api.builder.api;

import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.TeacherMapper;
import ru.salix.ejournal.api.model.api.TeacherDto;
import ru.salix.ejournal.api.model.dao.Teacher;

@Component
public class TeacherDtoBuilder extends BaseDtoBuilder<TeacherDto, Teacher> {

    public TeacherDtoBuilder(TeacherMapper mapper) {
        super(mapper);
    }

}
