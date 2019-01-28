package ru.salix.ejournal.api.dao.repository;

import org.springframework.stereotype.Repository;
import ru.salix.ejournal.api.model.dao.SchoolClass;
import ru.salix.ejournal.api.model.dao.Teacher;

import java.util.List;

@Repository
public interface SchoolClassRepository extends BaseRepository<SchoolClass> {

    List<SchoolClass> findAllByTeacher(Teacher teacher);

    List<SchoolClass> findAllByTeacherId(Long id);

}
