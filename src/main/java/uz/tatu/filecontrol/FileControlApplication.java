package uz.tatu.filecontrol;


import javafx.application.Application;
import org.apache.poi.sl.usermodel.ObjectMetaData;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FileControlApplication {

    public static void main(String[] args) {
        Application.launch(FileControllerFx.class, args);
    }

}
