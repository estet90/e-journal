package ru.salix.ejournal.api.model.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestDto extends BaseDtoEntity {

    private LessonDto lesson;

}
