package ru.salix.ejournal.api.dao.repository;

import org.springframework.stereotype.Repository;
import ru.salix.ejournal.api.model.dao.Subject;
import ru.salix.ejournal.api.model.dao.SubjectTeacher;
import ru.salix.ejournal.api.model.dao.Teacher;

@Repository
public interface SubjectTeacherRepository extends BaseRepository<SubjectTeacher> {

    long deleteSubjectTeacherByTeacherAndSubject(Teacher teacher, Subject subject);

}
