package ru.salix.ejournal.api.model.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(schema = "ejournal", name = "lesson_mark")
public class LessonMark extends Mark {

    @ManyToOne
    @JoinColumn(name = "id_lesson")
    private Lesson lesson;

    @ManyToOne
    @JoinColumn(name = "id_homework")
    private Homework homework;

    @ManyToOne
    @JoinColumn(name = "id_test")
    private Test test;

    @Column(name = "comment")
    private String comment;

}
