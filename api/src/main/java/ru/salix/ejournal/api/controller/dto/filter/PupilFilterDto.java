package ru.salix.ejournal.api.controller.dto.filter;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PupilFilterDto {

    private Long id;
    private String className;
    private String name;
    private String surname;
    private String patronymic;
    private String description;

}
