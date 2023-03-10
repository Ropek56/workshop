package cz.ys.workshop.department;

import cz.ys.workshop.department.dto.DepartmentObject;
import cz.ys.workshop.department.model.DepartmentEntity;
import cz.ys.workshop.person.PersonService;
import cz.ys.workshop.person.dto.PersonObject;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DepartmentService {

    private final DepartmentRepository repo;

    private final DepartmentMapper mapper;
    
    private final PersonService personService;

    public DepartmentService(DepartmentRepository repo, DepartmentMapper mapper, PersonService personService) {
        this.repo = repo;
        this.mapper = mapper;
        this.personService = personService;
    }

    @Transactional(readOnly = true)
    public List<DepartmentObject> findAll() {
        return mapper.toObject(repo.findAll());
    }
    
    @Transactional(readOnly = true)
    public List<PersonObject> findPersonsByDepartment(String number) {
    	List<PersonObject> persons = personService.findAll().stream()
    			.filter((person) -> person.departmentNumber().equals(number))
                .collect(Collectors.toList());
    	return persons;
    }

    @Transactional(readOnly = true)
    public DepartmentObject findById(String number) {
        return mapper.toObject(repo.findById(number).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @Transactional
    public void create(DepartmentObject object) {
        repo.save(mapper.toEntity(object));
    }

    @Transactional
    public void update(DepartmentObject object) {
        DepartmentEntity entity = repo.findById(object.number()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        entity.setName(object.name());
        repo.save(entity);
    }
}
