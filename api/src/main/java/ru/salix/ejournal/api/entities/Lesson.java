package ru.salix.ejournal.api.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(schema = "ejournal", name = "lesson")
public class Lesson extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "id_timetable")
    private Timetable timetable;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "comment")
    private String comment;

}
