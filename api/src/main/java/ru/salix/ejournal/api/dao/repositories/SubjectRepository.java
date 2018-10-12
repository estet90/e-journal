package ru.salix.ejournal.api.dao.repositories;

import org.springframework.stereotype.Repository;
import ru.salix.ejournal.api.entities.Subject;
import ru.salix.ejournal.api.entities.Teacher;

import java.util.List;

@Repository
public interface SubjectRepository extends BaseRepository<Subject> {

    List<Subject> findAllByTeachersIs(Teacher teacher);

}
