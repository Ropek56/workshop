package cz.ys.workshop.department.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Department")
public class DepartmentEntity {

    @Id
    public String number;

    public String name;


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
