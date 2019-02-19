package ru.salix.ejournal.api.model.api.filter;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class TeacherFilterDto {

    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private String description;
    private String subject;
    private String relatedClassName;
    private String ownClassName;
    private String examSubject;
    private LocalDateTime examDatetimeFrom;
    private LocalDateTime examDatetimeTo;
    private String examClassName;

}
