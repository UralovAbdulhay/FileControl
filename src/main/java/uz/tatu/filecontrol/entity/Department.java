package uz.tatu.filecontrol.entity;

//import javax.persistence.Entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Department  {

    @Id
    Integer id;

    @OneToMany(mappedBy = "department")
    List<Subject> subjects;

    String name;

    // bog'lanishlarni hal qilish kere

}
