package ru.salix.ejournal.api.model.api.filter;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalTime;

@Builder
@Getter
public class LessonPeriodFilterDto {

    private Long id;
    private LocalTime timeStartFrom;
    private LocalTime timeStartTo;
    private LocalTime timeEndFrom;
    private LocalTime timeEndTo;
    private int number;
    private int shift;

}
