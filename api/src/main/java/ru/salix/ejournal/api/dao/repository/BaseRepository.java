package ru.salix.ejournal.api.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.salix.ejournal.api.model.dao.BaseEntity;

public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {
}
