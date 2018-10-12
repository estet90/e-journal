package ru.salix.ejournal.api.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.salix.ejournal.api.entities.BaseEntity;

public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Long> {
}
