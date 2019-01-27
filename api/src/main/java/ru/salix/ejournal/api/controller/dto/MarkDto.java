package ru.salix.ejournal.api.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MarkDto extends BaseDtoEntity {

    protected long value;
    protected PupilDto pupil;
    protected LocalDateTime datetime;

}
