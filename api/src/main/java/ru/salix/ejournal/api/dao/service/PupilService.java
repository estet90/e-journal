package ru.salix.ejournal.api.dao.service;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.dao.repository.PupilRepository;
import ru.salix.ejournal.api.dao.specification.PupilSpecifications;
import ru.salix.ejournal.api.model.api.filter.PupilFilterDto;
import ru.salix.ejournal.api.model.dao.Pupil;

import java.util.List;

import static ru.salix.ejournal.api.error.exception.InvocationExceptionCode.DB_EXCEPTION;
import static ru.salix.ejournal.api.helper.DbQueryWrapper.execute;

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

    public Pupil findBySchoolClassIdAndId(Long idClass, Long idPupil) {
        return execute(() -> repository.findBySchoolClassIdAndId(idClass, idPupil), DB_EXCEPTION);
    }

}
