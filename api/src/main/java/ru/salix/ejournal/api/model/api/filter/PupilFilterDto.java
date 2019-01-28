package ru.salix.ejournal.api.model.api.filter;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PupilFilterDto {

    private Long id;
    private String className;
    private String name;
    private String surname;
    private String patronymic;
    private String description;

}
