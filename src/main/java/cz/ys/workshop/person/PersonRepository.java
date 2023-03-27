package cz.ys.workshop.person;

import cz.ys.workshop.department.model.DepartmentEntity;
import cz.ys.workshop.person.model.PersonEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<PersonEntity, String> {
	
	public List<PersonEntity> getPersonByDepartment(DepartmentEntity department);
	
	@Query("SELECT a, b FROM Person a JOIN a.department b")
	public List<PersonEntity> findAll();

}
