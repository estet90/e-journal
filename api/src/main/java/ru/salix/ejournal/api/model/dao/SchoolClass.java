package ru.salix.ejournal.api.model.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(schema = "ejournal", name = "class")
public class SchoolClass extends BaseEntity {

    @Column(name = "number")
    private int number;

    @Column(name = "liter")
    private char liter;

    @ManyToOne
    @JoinColumn(name = "id_teacher")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "id_period")
    private Period period;

    @OneToMany
    @JoinColumn(name = "id_class")
    private List<Timetable> timetables;

    @OneToMany
    @JoinColumn(name = "id_class")
    private List<Pupil> pupils;

}
