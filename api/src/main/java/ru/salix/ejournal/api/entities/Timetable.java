package ru.salix.ejournal.api.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "timetable")
public class Timetable extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "id_class")
    private SchoolClass schoolClass;

    @ManyToOne
    @JoinColumn(name = "id_subject")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "id_teacher")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "id_lesson_period")
    private LessonPeriod lessonPeriod;

    @ManyToOne
    @JoinColumn(name = "id_period")
    private Period period;

    @Column(name = "ay_of_week")
    private int dayOfWeek;

}
