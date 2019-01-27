package ru.salix.ejournal.api.dao.service;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.controller.dto.filter.PupilFilterDto;
import ru.salix.ejournal.api.dao.repository.PupilRepository;
import ru.salix.ejournal.api.dao.specification.PupilSpecifications;
import ru.salix.ejournal.api.entity.Pupil;

import java.util.List;

@Service
public class PupilService extends BaseService<Pupil, PupilRepository> {

    private final PupilSpecifications pupilSpecifications;

    public PupilService(PupilRepository repository, PupilSpecifications pupilSpecifications) {
        super(repository);
        this.pupilSpecifications = pupilSpecifications;
    }

    public List<Pupil> filter(PupilFilterDto filter) {
        return filter(pupilSpecifications.filterSpecification(filter));
    }

}
