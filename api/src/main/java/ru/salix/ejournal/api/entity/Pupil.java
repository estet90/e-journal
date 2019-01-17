package ru.salix.ejournal.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(schema = "ejournal", name = "pupil")
public class Pupil extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "id_class")
    private SchoolClass schoolClass;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "description")
    private String description;
}
