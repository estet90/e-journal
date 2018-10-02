package ru.salix.ejournal.api.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "teacher")
public class Teacher extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "description")
    private String description;

    @ManyToMany
    @JoinTable(name = "subject_teacher",
            joinColumns = @JoinColumn(name = "id_teacher"),
            inverseJoinColumns = @JoinColumn(name = "id_subject"))
    private List<Subject> subjects;
}
