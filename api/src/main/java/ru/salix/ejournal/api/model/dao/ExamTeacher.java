package ru.salix.ejournal.api.model.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(schema = "ejournal", name = "exam_teacher")
public class ExamTeacher extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "id_exam")
    private Exam exam;

    @ManyToOne
    @JoinColumn(name = "id_teacher")
    private Teacher teacher;

}
