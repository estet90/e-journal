package ru.salix.ejournal.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(schema = "ejournal", name = "period")
public class Period extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "id_period_type")
    private PeriodType periodType;

    @Column(name = "date_start")
    private LocalDate dateStart;

    @Column(name = "date_end")
    private LocalDate dateEnd;

}