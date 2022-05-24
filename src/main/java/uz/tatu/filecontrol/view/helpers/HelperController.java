package uz.tatu.filecontrol.view.helpers;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import uz.tatu.filecontrol.entity.Department;

public class HelperController {


    public static void setValueFactoryDepartmentTable(
            TableView<Department> departmentTableView,
            TableColumn<Department, Integer> numberCol,
            TableColumn<Department, String> nameCol,
            TableColumn<Department, Integer> countCol
    ) {

        numberCol.setCellValueFactory(
                e ->
                        new SimpleObjectProperty<>(
                                e.getValue().getId()
                        ));

        nameCol.setCellValueFactory(
                e ->
                        new SimpleObjectProperty<>(
                                e.getValue().getName()
                        ));

        countCol.setCellValueFactory(
                e ->
                        new SimpleObjectProperty<>(
                                e.getValue().getId() + 10
                        ));


    }

}
