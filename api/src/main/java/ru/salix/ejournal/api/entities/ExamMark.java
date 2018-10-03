package ru.salix.ejournal.api.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(schema = "ejournal", name = "exam_mark")
public class ExamMark extends Mark {

    @ManyToOne
    @JoinColumn(name = "id_exam")
    private Exam exam;

}
