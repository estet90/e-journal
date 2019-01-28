package ru.salix.ejournal.api.model.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(schema = "ejournal", name = "period_type")
public class PeriodType extends BaseEntity {

    @Column(name = "name")
    private String name;

}
