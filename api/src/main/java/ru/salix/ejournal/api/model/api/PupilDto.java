package ru.salix.ejournal.api.model.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PupilDto extends BaseDtoEntity {

    private SchoolClassDto schoolClass;
    private String name;
    private String surname;
    private String patronymic;
    private String description;

}
