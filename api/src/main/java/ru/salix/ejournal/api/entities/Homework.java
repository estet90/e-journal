package ru.salix.ejournal.api.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "homework")
public class Homework extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "id_lesson_receive")
    private Lesson lessonReceive;

    @ManyToOne
    @JoinColumn(name = "id_lesson_complete")
    private Lesson lessonComplete;

    @Column(name = "description")
    private String description;

}
