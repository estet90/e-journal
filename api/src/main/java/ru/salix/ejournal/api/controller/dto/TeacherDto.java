package ru.salix.ejournal.api.controller.dto;

import lombok.*;

import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDto {

    private long id;
    private String name;
    private String surname;
    private String patronymic;
    private String description;

}
