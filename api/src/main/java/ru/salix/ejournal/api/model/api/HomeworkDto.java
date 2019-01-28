package ru.salix.ejournal.api.model.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HomeworkDto extends BaseDtoEntity {

    private LessonDto lessonReceive;
    private LessonDto lessonComplete;
    private String description;

}
