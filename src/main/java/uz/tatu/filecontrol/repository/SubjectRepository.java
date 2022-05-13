package uz.tatu.filecontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.tatu.filecontrol.entity.Subject;

public interface SubjectRepository  extends JpaRepository<Subject, Integer> {
}
