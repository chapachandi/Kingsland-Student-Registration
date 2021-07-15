package controller;

import bo.BoFactory;
import bo.custom.StudentBO;
import dao.StudentDAO;
import dto.StudentDTO;
import entity.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import view.tm.StudentTM;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentController {


    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtContact;
    public TextField txtDob;
    public TextField txtGender;
    public TextField txtSearch;
    public TableView<StudentDTO> tblStudent;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colContact;
    public TableColumn colDob;
    public TableColumn colGender;
    public AnchorPane root;

    StudentBO bo;
    public void initialize() throws Exception {

        //loadId();

       // bo = BoFactory.getInstance().getBo(BoFactory.BOType.STUDENT);

//        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
//        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
//        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
//        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
//        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
//        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));

      // loadAllStudents();

        //------------------------------ set Listener-------------

        tblStudent.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                    setData(newValue);
                });

        //------------------------------ set Listener-------------
    }

    private void loadId() throws Exception {
        String id = bo.getId();
        System.out.println(id);
    }

    private void setData(StudentDTO tm) {
        txtId.setText(tm.getId());
        txtName.setText(tm.getName());
        txtAddress.setText(tm.getAddress());
        txtContact.setText(tm.getContact());
        txtDob.setText(tm.getDob());
        txtGender.setText(tm.getGendeer());
    }

    private void loadAllStudents()  {
        ObservableList<StudentDTO> tmList = FXCollections.observableArrayList();
        ArrayList<StudentDTO>allStudents=null;
        try {
            allStudents = bo.getAllStudents();
        } catch (Exception e) {

        }
        for (StudentDTO dto : allStudents) {
           tmList.add(new StudentDTO(dto.getId(), dto.getName(), dto.getAddress(), dto.getContact(), dto.getDob(), dto.getGendeer()));
            }
            tblStudent.setItems(tmList);


    }

    public void btnSaveOnAction(ActionEvent actionEvent) throws Exception {
        boolean isSaved = bo.saveStudent(
                new StudentDTO(txtId.getText(),
                        txtName.getText(),
                        txtAddress.getText(),txtContact.getText(),txtDob.getText(),txtGender.getText()));
        System.out.println(isSaved);

    }
}
