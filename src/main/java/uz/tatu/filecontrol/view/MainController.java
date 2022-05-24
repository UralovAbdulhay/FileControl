package uz.tatu.filecontrol.view;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import lombok.RequiredArgsConstructor;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;
import uz.tatu.filecontrol.entity.Department;
import uz.tatu.filecontrol.entity.FileContent;
import uz.tatu.filecontrol.entity.Subject;
import uz.tatu.filecontrol.service.DepartmentService;
import uz.tatu.filecontrol.service.FileContentService;
import uz.tatu.filecontrol.service.MyFileService;
import uz.tatu.filecontrol.service.SubjectService;
import uz.tatu.filecontrol.view.helpers.HelperController;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Component
@FxmlView
@RequiredArgsConstructor
public class MainController implements Initializable {


    private final DepartmentService departmentService;
    private final FileContentService fileContentService;
    private final MyFileService myFileService;
    private final SubjectService subjectService;

    @FXML
    private TableColumn<Department, Integer> departmentOrder;
    @FXML
    private TableColumn<Department, String> departmentName;
    @FXML
    private TableColumn<Department, Integer> departmentCount;
    @FXML
    private TableColumn subOrder;
    @FXML
    private TableColumn subName;
    @FXML
    private TableColumn subCount;
    @FXML
    private TableColumn otherOrder;
    @FXML
    private TableColumn otherName;
    @FXML
    private TableColumn otherContent;
    @FXML
    private TableColumn labOrder;
    @FXML
    private TableColumn labName;
    @FXML
    private TableColumn labContent;
    @FXML
    private TableColumn pracOrder;
    @FXML
    private TableColumn pracName;
    @FXML
    private TableColumn pracContent;
    @FXML
    private TableColumn lecOrder;
    @FXML
    private TableColumn lecName;
    @FXML
    private TableColumn lecContent;
    @FXML
    private TextField kafFind;
    @FXML
    private TableView<Department> departmentTable;
    @FXML
    private TextField fanFind;
    @FXML
    private TableView<Subject> fanTable;
    @FXML
    private TextField contFind;
    @FXML
    private Tab lecTab;
    @FXML
    private TableView<?> lectureTable;
    @FXML
    private Tab prTab;
    @FXML
    private TableView<FileContent> practiseTable;
    @FXML
    private Tab labTab;
    @FXML
    private TableView<FileContent> laboratoryTable;
    @FXML
    private Tab otherTab;
    @FXML
    private TableView<FileContent> otherTable;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        loadContentContextMenus();
        loadSubjectContextMenu();
        loadDepartmentContextMenu();

    }

    private void loadDepartmentContextMenu() {

        final ContextMenu contextMenu1 = new ContextMenu();

        MenuItem addDep1 = new MenuItem("Add");

        contextMenu1.getItems().addAll(addDep1);

        departmentTable.setContextMenu(contextMenu1);

        departmentTable.setRowFactory(row -> {
            final TableRow<Department> newRow = new TableRow<>();
            final ContextMenu contextMenu = new ContextMenu();

            MenuItem addDep = new MenuItem("Add");
            MenuItem delDep = new MenuItem("Delete");

            contextMenu.getItems().addAll(addDep, delDep);

            newRow.contextMenuProperty().bind(
                    Bindings.when(Bindings.isNotNull(newRow.itemProperty()))
                            .then(contextMenu)
                            .otherwise(new ContextMenu(addDep))
            );

            return newRow;
        });

        HelperController.setValueFactoryDepartmentTable(departmentTable, departmentOrder, departmentName, departmentCount);
        List<Department> all = departmentService.findAll();
        ObservableList<Department> observableList = FXCollections.observableList(all);
        departmentTable.setItems(observableList);

        departmentTable.refresh();
    }



    private void loadSubjectContextMenu() {

        ContextMenu contextMenu = new ContextMenu();
        MenuItem add = new MenuItem("Add");
        MenuItem del = new MenuItem("Delete");

        contextMenu.getItems().addAll(add, del);
        fanTable.setContextMenu(contextMenu);
        fanTable.refresh();
    }

    private void loadContentContextMenus() {
        ContextMenu contextMenu = new ContextMenu();
        MenuItem add = new MenuItem("Add");
        MenuItem del = new MenuItem("Delete");
        MenuItem save = new MenuItem("Save as...");

        contextMenu.getItems().addAll(add, del, save);

        lectureTable.setContextMenu(contextMenu);
        practiseTable.setContextMenu(contextMenu);
        laboratoryTable.setContextMenu(contextMenu);
        otherTable.setContextMenu(contextMenu);
        otherTable.refresh();
        laboratoryTable.refresh();
        lectureTable.refresh();
        practiseTable.refresh();
    }


}
