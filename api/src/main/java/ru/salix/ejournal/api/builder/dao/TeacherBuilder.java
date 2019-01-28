package ru.salix.ejournal.api.builder.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.model.api.TeacherDto;
import ru.salix.ejournal.api.model.dao.Teacher;
import ru.salix.ejournal.api.mapper.TeacherMapper;

@Component
@RequiredArgsConstructor
public class TeacherBuilder extends AbstractDaoBuilder<Teacher, TeacherDto> {

    private final TeacherMapper teacherMapper;

    @Override
    public Teacher build(TeacherDto teacherDto) {
        return teacherMapper.teacherDtoToTeacher(teacherDto);
    }

}
