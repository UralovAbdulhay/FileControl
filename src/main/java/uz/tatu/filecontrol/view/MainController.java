package uz.tatu.filecontrol.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import lombok.RequiredArgsConstructor;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView
@RequiredArgsConstructor


public class MainController {

    @FXML
    private TextField kafFind;

    @FXML
    private ListView<?> kafedraList;

    @FXML
    private TextField fanFind;

    @FXML
    private ListView<?> fanList;

    @FXML
    private TextField contFind;

    @FXML
    private Tab lecTab;

    @FXML
    private ListView<?> lecList;

    @FXML
    private Tab prTab;

    @FXML
    private ListView<?> prList;

    @FXML
    private Tab labTab;

    @FXML
    private ListView<?> labList;

    @FXML
    private Tab otherTab;

    @FXML
    private ListView<?> otherList;

    @FXML
    private MenuItem closeMenuItem;

    @FXML
    private MenuItem addFileMenuItem;

    @FXML
    private MenuItem aboutMenuItem;

    @FXML
    void addFiles(ActionEvent event) {

    }

    @FXML
    void closeApp(ActionEvent event) {

    }

    @FXML
    void showAbout(ActionEvent event) {

    }

}
