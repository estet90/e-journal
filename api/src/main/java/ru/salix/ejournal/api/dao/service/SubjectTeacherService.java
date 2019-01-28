package ru.salix.ejournal.api.dao.service;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.model.dao.Subject;
import ru.salix.ejournal.api.model.dao.SubjectTeacher;
import ru.salix.ejournal.api.dao.repository.SubjectTeacherRepository;
import ru.salix.ejournal.api.model.dao.Teacher;

@Service
public class SubjectTeacherService extends BaseService<SubjectTeacher, SubjectTeacherRepository> {

    public SubjectTeacherService(SubjectTeacherRepository repository) {
        super(repository);
    }

    public void save(Teacher teacher, Subject subject) {
        var subjectTeacher = new SubjectTeacher();
        subjectTeacher.setSubject(subject);
        subjectTeacher.setTeacher(teacher);
        save(subjectTeacher);
    }

    public Long delete(Teacher teacher, Subject subject) {
        return repository.deleteSubjectTeacherByTeacherAndSubject(teacher, subject);
    }

}
