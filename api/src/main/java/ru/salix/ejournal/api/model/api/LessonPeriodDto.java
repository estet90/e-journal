package ru.salix.ejournal.api.model.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LessonPeriodDto extends BaseDtoEntity {

    private int number;
    private LocalTime timeStart;
    private LocalTime timeEnd;
    private int shift;

}
