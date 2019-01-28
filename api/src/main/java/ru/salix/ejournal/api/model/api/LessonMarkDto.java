package ru.salix.ejournal.api.model.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LessonMarkDto extends MarkDto {

    private LessonDto lesson;
    private HomeworkDto homework;
    private TestDto test;
    private String comment;

}
