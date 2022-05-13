package uz.tatu.filecontrol.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import uz.tatu.filecontrol.entity.Subject;
import uz.tatu.filecontrol.repository.SubjectRepository;
import uz.tatu.filecontrol.service.basic.BaseService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService implements BaseService<Subject, Integer> {


    private final SubjectRepository subjectRepository;


    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject findById(Integer id) {
        return subjectRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, "Subject"));
    }

    @Override
    public void deleteById(Integer id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public Subject save(Subject entity) {
        return subjectRepository.save(entity);
    }


}
