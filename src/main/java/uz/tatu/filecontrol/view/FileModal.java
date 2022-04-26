package uz.tatu.filecontrol.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lombok.RequiredArgsConstructor;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView
@RequiredArgsConstructor
public class FileModal {

    @FXML
    private ComboBox<?> kafCombo;

    @FXML
    private ComboBox<?> fanCombo;

    @FXML
    private RadioButton lecRB;

    @FXML
    private ToggleGroup myGroup;

    @FXML
    private RadioButton prRB;

    @FXML
    private RadioButton labRB;

    @FXML
    private RadioButton othRB;

    @FXML
    private Button addBtn;

    @FXML
    private ListView<?> fileList;

    @FXML
    private Button cancleBtn;

    @FXML
    private Button okBtn;

    @FXML
    void addAll(ActionEvent event) {

    }

    @FXML
    void closeModal(ActionEvent event) {

    }

    @FXML
    void fanComboEvent(ActionEvent event) {
//salom
    }

    @FXML
    void kafComboEvent(ActionEvent event) {

    }

    @FXML
    void openFiles(ActionEvent event) {

    }

    @FXML
    void rbSwitch(ActionEvent event) {

    }




}

