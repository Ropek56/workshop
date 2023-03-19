package cz.ys.workshop.person;

import cz.ys.workshop.person.dto.PersonObject;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    // TODO: doplnit metodu GET na nacteni vsech zamestnancu

    @GetMapping
    public List<PersonObject> findAll() {
        return service.findAll();
    }
    
    @GetMapping("/{number}")
    public PersonObject findById(@PathVariable String number) {
        return service.findById(number);
    }
}
