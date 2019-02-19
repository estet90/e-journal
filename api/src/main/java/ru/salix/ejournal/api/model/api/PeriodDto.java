package ru.salix.ejournal.api.model.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeriodDto extends BaseDtoEntity {

    private PeriodTypeDto periodType;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private List<TimetableDto> timetables;

}
