package cz.ys.workshop.person;

import cz.ys.workshop.person.dto.PersonObject;
import cz.ys.workshop.person.model.PersonEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class PersonMapper {

    @Mapping(target = "departmentNumber", source = "department.number")
    @Mapping(target = "departmentName", source = "department.name")
    public abstract PersonObject toObject(PersonEntity entity);
    public abstract List<PersonObject> toObject(List<PersonEntity> entities);

}
