package hu.wurfel.refference.school.subject;

import hu.wurfel.refference.school.base.enums.EntityFieldNames;
import hu.wurfel.refference.school.base.enums.EntityNames;
import lombok.Data;

import java.io.Serializable;

@Data
public class SubjectRequestForSearch implements Serializable {
    private EntityNames searchFor;
    private EntityNames searchWith;
    private EntityFieldNames searchBy;
    private String searchValue;
    private String id;
    private String name;
    private String teacherId;
}
