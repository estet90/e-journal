package ru.salix.ejournal.api.dao.repository;

import org.springframework.stereotype.Repository;
import ru.salix.ejournal.api.entity.SchoolClass;
import ru.salix.ejournal.api.entity.Teacher;

import java.util.List;

@Repository
public interface SchoolClassRepository extends BaseRepository<SchoolClass> {

    List<SchoolClass> findAllByTeacher(Teacher teacher);

    List<SchoolClass> findAllByTeacherId(Long id);

}
