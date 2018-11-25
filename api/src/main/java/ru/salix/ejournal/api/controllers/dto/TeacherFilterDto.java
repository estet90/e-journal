package ru.salix.ejournal.api.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherFilterDto {

    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private String description;
    private String subject;
    private String relatedClassName;
    private String ownClassName;

}
