package ru.salix.ejournal.api.model.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(schema = "ejournal", name = "exam")
public class Exam extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "id_class")
    private SchoolClass schoolClass;

    @ManyToOne
    @JoinColumn(name = "id_subject")
    private Subject subject;

    @Column(name = "datetime")
    private LocalDateTime datetime;

    @ManyToMany
    @JoinTable(schema = "ejournal", name = "exam_teacher",
            joinColumns = @JoinColumn(name = "id_exam"),
            inverseJoinColumns = @JoinColumn(name = "id_teacher"))
    private List<Teacher> teachers;

}
