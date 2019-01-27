package ru.salix.ejournal.api.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeriodDto extends BaseDtoEntity {

    private PeriodTypeDto periodType;
    private LocalDate dateStart;
    private LocalDate dateEnd;

}
