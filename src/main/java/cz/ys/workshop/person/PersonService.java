package cz.ys.workshop.person;

import cz.ys.workshop.department.dto.DepartmentObject;
import cz.ys.workshop.person.dto.PersonObject;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PersonService {

    private final PersonRepository repo;

    private final PersonMapper mapper;

    public PersonService(PersonRepository repo, PersonMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public PersonObject findById(String number) {
        return mapper.toObject(repo.findById(number).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }
    
    @Transactional(readOnly = true)
    public List<PersonObject> findAll() {
        return mapper.toObject(repo.findAll());
    }


}
