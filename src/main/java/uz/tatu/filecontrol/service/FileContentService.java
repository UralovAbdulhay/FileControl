package uz.tatu.filecontrol.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import uz.tatu.filecontrol.entity.FileContent;
import uz.tatu.filecontrol.repository.FileContentRepository;
import uz.tatu.filecontrol.service.basic.BaseService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FileContentService implements BaseService<FileContent, Integer> {

    private final FileContentRepository fileContentRepository;


    @Override
    public List<FileContent> findAll() {
        return fileContentRepository.findAll();
    }

    @Override
    public FileContent findById(Integer id) {
        return fileContentRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, "FileContent"));
    }

    @Override
    public void deleteById(Integer id) {
        fileContentRepository.deleteById(id);
    }

    @Override
    public FileContent save(FileContent entity) {
        return fileContentRepository.save(entity);
    }

}
