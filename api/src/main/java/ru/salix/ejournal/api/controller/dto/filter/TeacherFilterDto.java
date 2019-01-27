package ru.salix.ejournal.api.controller.dto.filter;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
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
