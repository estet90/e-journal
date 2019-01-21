package ru.salix.ejournal.api.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PupilDto {

    private Long id;
    private SchoolClassDto schoolClass;
    private String name;
    private String surname;
    private String patronymic;
    private String description;

}
