package cz.ys.workshop.department;

import cz.ys.workshop.department.dto.DepartmentObject;
import cz.ys.workshop.person.dto.PersonObject;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping
    public List<DepartmentObject> findAll() {
        return service.findAll();
    }

    // TODO: doplnit metodu GET na detail jednoho oddeleni
    
    @GetMapping("/{number}")
    public DepartmentObject findById(@PathVariable String number) {
        return service.findById(number);
    }
    
    @PostMapping
    public void create(@RequestBody DepartmentObject object) {
        service.create(object);
    }

    @PutMapping
    public void update(@RequestBody DepartmentObject object) {
        service.update(object);
    }

    // TODO: doplnit metodu GET pro ziskani seznamu zamestnancu jednoho oddeleni
    
    @GetMapping("/persons/{number}")
    public List<PersonObject> findPersonsByDepartment(@PathVariable String number) {
        return service.findPersonsByDepartment(number);
    }
}
