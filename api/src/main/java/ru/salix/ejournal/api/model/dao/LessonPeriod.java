package ru.salix.ejournal.api.model.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(schema = "ejournal", name = "lesson_period")
public class LessonPeriod extends BaseEntity {

    @Column(name = "number")
    private int number;

    @Column(name = "time_start")
    private LocalTime timeStart;

    @Column(name = "time_end")
    private LocalTime timeEnd;

    @Column(name = "shift")
    private int shift;

}
