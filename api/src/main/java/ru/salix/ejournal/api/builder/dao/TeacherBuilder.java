package ru.salix.ejournal.api.builder.dao;

import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.TeacherMapper;
import ru.salix.ejournal.api.model.api.TeacherDto;
import ru.salix.ejournal.api.model.dao.Teacher;

@Component
public class TeacherBuilder extends BaseDaoBuilder<Teacher, TeacherDto> {

    public TeacherBuilder(TeacherMapper mapper) {
        super(mapper);
    }

}
