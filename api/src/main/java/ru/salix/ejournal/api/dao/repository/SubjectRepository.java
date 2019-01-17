package ru.salix.ejournal.api.dao.repository;

import org.springframework.stereotype.Repository;
import ru.salix.ejournal.api.entity.Subject;
import ru.salix.ejournal.api.entity.Teacher;

import java.util.List;

@Repository
public interface SubjectRepository extends BaseRepository<Subject> {

    List<Subject> findAllByTeachersIs(Teacher teacher);

}
