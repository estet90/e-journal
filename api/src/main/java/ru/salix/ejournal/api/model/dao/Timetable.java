package ru.salix.ejournal.api.model.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(schema = "ejournal", name = "timetable")
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

    @Column(name = "day_of_week")
    private Integer dayOfWeek;

}
