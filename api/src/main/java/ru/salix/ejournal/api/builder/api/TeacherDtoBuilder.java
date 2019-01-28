package ru.salix.ejournal.api.builder.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.model.api.TeacherDto;
import ru.salix.ejournal.api.model.dao.Teacher;
import ru.salix.ejournal.api.mapper.TeacherMapper;

@Component
@RequiredArgsConstructor
public class TeacherDtoBuilder extends AbstractDtoBuilder<TeacherDto, Teacher> {

    private final TeacherMapper teacherMapper;

    @Override
    public TeacherDto build(Teacher teacher) {
        return teacherMapper.teacherToTeacherDto(teacher);
    }

    @Override
    public TeacherDto buildWithRelatedObjects(Teacher entity) {
        return null;
    }

}
