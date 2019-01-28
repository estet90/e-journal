package ru.salix.ejournal.api.dao.repository;

import org.springframework.stereotype.Repository;
import ru.salix.ejournal.api.model.dao.Subject;
import ru.salix.ejournal.api.model.dao.Teacher;

import java.util.List;

@Repository
public interface SubjectRepository extends BaseRepository<Subject> {

    List<Subject> findAllByTeachersIs(Teacher teacher);

}
