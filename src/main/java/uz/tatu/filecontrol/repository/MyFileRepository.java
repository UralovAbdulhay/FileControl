package uz.tatu.filecontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.tatu.filecontrol.entity.Department;
import uz.tatu.filecontrol.entity.MyFile;

public interface MyFileRepository extends JpaRepository<MyFile, String> {
}
