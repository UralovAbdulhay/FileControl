package uz.tatu.filecontrol.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.tatu.filecontrol.entity.MyFile;
import uz.tatu.filecontrol.entity.util.FileType;
import uz.tatu.filecontrol.errors.ResourceNotFound;
import uz.tatu.filecontrol.repository.MyFileRepository;
import uz.tatu.filecontrol.service.basic.BaseService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

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
        return myFileRepository.findById(id).orElseThrow(() -> new ResourceNotFound(id, "id", "MyFile"));
    }

    @Override
    public void deleteById(String id) {
        myFileRepository.deleteById(id);
    }

    @Override
    public MyFile save(MyFile entity) {
        return myFileRepository.save(entity);
    }


    public String saveToFile(File outDir, String hashId) throws IOException {

        MyFile myFile = findById(hashId);

        //to'g'rilash kere
        outDir.mkdirs();

        File file = new File(outDir, myFile.getName());
        int count = 1;

        while (file.exists()) {
            file = new File(outDir, myFile.getName() + " (" + (count++) + ")");
        }

        OutputStream outputStream = new FileOutputStream(file);

        outputStream.write(myFile.getData());
        outputStream.flush();
        outputStream.close();

        return file.getAbsolutePath();
    }


    public MyFile toMyFile(File file, FileType fileType) {

        try {
            Path path = Path.of(file.toURI());
            byte[] bytes = Files.readAllBytes(path);
            MyFile myFile = new MyFile(
                    UUID.randomUUID().toString(),
                    file.getName(),
                    getExtension(file.getName()),
                    Files.size(path) / 1024,
                    bytes,
                    createUploadPath(file.getName(), fileType)
            );

            return myFile;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    private String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    private String createUploadPath(String fileName, FileType fileType) {

        String filePath = String.format("files/%s/%s/%s",
                fileType.toString(),
                DateTimeFormatter.ofPattern("dd-MM-yyyy").format(LocalDateTime.now()),
                getExtension(fileName)
        );

        return filePath;
    }

}
