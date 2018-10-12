package ru.salix.ejournal.api.dao.repositories;

import org.springframework.stereotype.Repository;
import ru.salix.ejournal.api.entities.SchoolClass;
import ru.salix.ejournal.api.entities.Teacher;

import java.util.List;

@Repository
public interface SchoolClassRepository extends BaseRepository<SchoolClass> {

    List<SchoolClass> findAllByTeacher(Teacher teacher);

}
