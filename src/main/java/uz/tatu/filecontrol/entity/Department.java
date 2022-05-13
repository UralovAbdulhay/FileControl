package uz.tatu.filecontrol.entity;

//import javax.persistence.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Department {

    @Id
    Integer id;

    @OneToMany(mappedBy = "department")
    List<Subject> subjects;

    String name;

    // bog'lanishlarni hal qilish kere

}
