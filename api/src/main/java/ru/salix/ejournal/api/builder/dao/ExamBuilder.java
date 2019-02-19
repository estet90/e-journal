package ru.salix.ejournal.api.builder.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.ExamMapper;
import ru.salix.ejournal.api.model.api.ExamDto;
import ru.salix.ejournal.api.model.dao.Exam;

@Component
@RequiredArgsConstructor
public class ExamBuilder extends AbstractDaoBuilder<Exam, ExamDto> {

    private final ExamMapper examMapper;

    @Override
    public Exam build(ExamDto examDto) {
        return examMapper.fromDto(examDto);
    }

    @Override
    public Exam buildWithRelatedObjects(ExamDto examDto) {
        return examMapper.fromDtoWithRelatedObjects(examDto);
    }

    public Exam buildWithRelatedObjects(ExamDto examDto, Long id) {
        var exam = examMapper.fromDtoWithRelatedObjects(examDto);
        exam.setId(id);
        return exam;
    }

}

