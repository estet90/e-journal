package ru.salix.ejournal.api.dao.repository;

import org.springframework.stereotype.Repository;
import ru.salix.ejournal.api.model.dao.Pupil;

@Repository
public interface PupilRepository extends BaseRepository<Pupil> {

    Pupil findBySchoolClassIdAndId(Long schoolClassID, Long id);

}
