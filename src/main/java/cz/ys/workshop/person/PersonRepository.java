package cz.ys.workshop.person;

import cz.ys.workshop.person.model.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, String> {
}
