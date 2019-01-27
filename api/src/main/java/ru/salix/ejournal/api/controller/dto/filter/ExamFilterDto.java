package ru.salix.ejournal.api.controller.dto.filter;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class ExamFilterDto {

    private Long id;
    private LocalDateTime datetimeFrom;
    private LocalDateTime datetimeTo;
    private String className;
    private String subject;

}
