package uz.tatu.filecontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.tatu.filecontrol.entity.Department;


public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
