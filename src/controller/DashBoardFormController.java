package controller;

import dto.StudentDTO;
import entity.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBoardFormController {
    public AnchorPane root;



    public void btnStudentOnAction(ActionEvent actionEvent) throws IOException {
        initUi("Student.fxml");
    }

    public void btnCourseOnAction(ActionEvent actionEvent) throws IOException {
        initUi("CourseForm.fxml");
    }

    public void btnRegistrationOnAction(ActionEvent actionEvent) throws IOException {
        initUi("RegistrationForm.fxml");

    }

    private void initUi(String location) throws IOException {
        this.root.getChildren().clear();
        this.root.getChildren()
                .add(FXMLLoader.
                        load(this.getClass().getResource("/view/" + location)));

    }
}
