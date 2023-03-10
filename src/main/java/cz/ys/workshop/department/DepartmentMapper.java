package cz.ys.workshop.department;

import cz.ys.workshop.department.dto.DepartmentObject;
import cz.ys.workshop.department.model.DepartmentEntity;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public abstract class DepartmentMapper {

    public abstract DepartmentObject toObject(DepartmentEntity entity);
    public abstract List<DepartmentObject> toObject(List<DepartmentEntity> entities);

    public abstract DepartmentEntity toEntity(DepartmentObject object);

}
