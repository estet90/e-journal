package ru.salix.ejournal.api.dao.repository;

import org.springframework.stereotype.Repository;
import ru.salix.ejournal.api.entity.Subject;
import ru.salix.ejournal.api.entity.SubjectTeacher;
import ru.salix.ejournal.api.entity.Teacher;

@Repository
public interface SubjectTeacherRepository extends BaseRepository<SubjectTeacher> {

    long deleteSubjectTeacherByTeacherAndSubject(Teacher teacher, Subject subject);

}
