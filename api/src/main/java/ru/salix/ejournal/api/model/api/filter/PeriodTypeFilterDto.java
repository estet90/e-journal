package ru.salix.ejournal.api.model.api.filter;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PeriodTypeFilterDto {

    private Long id;
    private String name;

}
