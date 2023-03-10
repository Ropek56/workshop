package cz.ys.workshop.department;

import cz.ys.workshop.department.model.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, String> {
}
