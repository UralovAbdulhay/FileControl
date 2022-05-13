package uz.tatu.filecontrol.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import uz.tatu.filecontrol.entity.MyFile;
import uz.tatu.filecontrol.repository.MyFileRepository;
import uz.tatu.filecontrol.service.basic.BaseService;

import java.io.*;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MyFileService implements BaseService<MyFile, String> {


    private final MyFileRepository myFileRepository;


    @Override
    public List<MyFile> findAll() {
        return myFileRepository.findAll();
    }

    @Override
    public MyFile findById(String id) {
        return myFileRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, "MyFile"));
    }

    @Override
    public void deleteById(String id) {
        myFileRepository.deleteById(id);
    }

    @Override
    public MyFile save(MyFile entity) {
        return myFileRepository.save(entity);
    }


    public String saveToFile(File outdir, String hashId) throws IOException {

        MyFile myFile = findById(hashId);

        //to'g'rilash kere
        outdir.mkdirs();
        outdir.li
        File file = new File(outdir, myFile.getName())
        OutputStream outputStream = new FileOutputStream();
        outputStream.write(myFile.getData());


    }



}
