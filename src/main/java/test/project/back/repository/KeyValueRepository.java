package test.project.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.project.back.model.KeyValueModel;

public interface KeyValueRepository extends JpaRepository<KeyValueModel, Long> {
}
