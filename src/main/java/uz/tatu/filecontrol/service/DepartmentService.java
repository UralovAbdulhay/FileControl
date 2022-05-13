package uz.tatu.filecontrol.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import uz.tatu.filecontrol.entity.Department;
import uz.tatu.filecontrol.repository.DepartmentRepository;
import uz.tatu.filecontrol.service.basic.BaseService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService implements BaseService<Department, Integer> {

    private final DepartmentRepository departmentRepository;


    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findById(Integer id) {
        return departmentRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, "Department"));
    }

    @Override
    public void deleteById(Integer id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department save(Department entity) {
        return departmentRepository.save(entity);
    }



}
