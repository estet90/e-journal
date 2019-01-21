package ru.salix.ejournal.api.builder.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.controller.dto.TeacherDto;
import ru.salix.ejournal.api.entity.Teacher;
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
