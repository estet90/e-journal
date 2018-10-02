package ru.salix.ejournal.api.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Setter
public class Mark extends BaseEntity {

    @Column(name = "value")
    protected long value;

    @ManyToOne
    @JoinColumn(name = "id_pupil")
    protected Pupil pupil;

    @Column(name = "datetime")
    protected LocalDateTime datetime;

}
