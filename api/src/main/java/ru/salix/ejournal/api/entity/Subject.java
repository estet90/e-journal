package ru.salix.ejournal.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(schema = "ejournal", name = "subject")
public class Subject extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(schema = "ejournal", name = "subject_teacher",
            joinColumns = @JoinColumn(name = "id_subject"),
            inverseJoinColumns = @JoinColumn(name = "id_teacher"))
    private List<Teacher> teachers;

}
