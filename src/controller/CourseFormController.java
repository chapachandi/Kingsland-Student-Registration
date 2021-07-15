package controller;

import bo.BoFactory;
import bo.custom.CourseBo;
import dto.CourseDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import view.tm.CourseTM;

import java.util.ArrayList;
import java.util.Optional;

public class CourseFormController {

    public TextField txtCode;
    public TextField txtCourseName;
    public TextField txtCourseType;
    public TextField txtDuration;
    public TextField txtSearch;
    public TableView<CourseTM> tblCourse;
    public TableColumn colCode;
    public TableColumn colCourseName;
    public TableColumn colCourseType;
    public TableColumn colDeuration;
    public TableColumn colOperate;
    public AnchorPane root;

    CourseBo bo;

    public void initialize() throws Exception {

        //loadId();

        bo = BoFactory.getInstance().getBo(BoFactory.BOType.COURSE);

        colCode.setCellValueFactory(new PropertyValueFactory("code"));
        colCourseName.setCellValueFactory(new PropertyValueFactory("courseName"));
        colCourseType.setCellValueFactory(new PropertyValueFactory("courseType"));
        colDeuration.setCellValueFactory(new PropertyValueFactory("duration"));
        colOperate.setCellValueFactory(new PropertyValueFactory("btn"));

       // loadAllCourses();

        //------------------------------ set Listener-------------

        tblCourse.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    setData(newValue);
                });

        //------------------------------ set Listener-------------
    }

    ObservableList<CourseTM> tmList = FXCollections.observableArrayList();

    private void setData(CourseTM tm) {
        txtCode.setText(tm.getCode());
        txtCourseName.setText(tm.getCourseName());
        txtCourseType.setText(tm.getCourseType());
        txtDuration.setText(tm.getDuration());
    }

    private void loadAllCourses() throws Exception {
        ObservableList<CourseTM> tmList =
                FXCollections.observableArrayList();
        ArrayList<CourseDTO> allCourses = bo.getAllCourses();
        for (CourseDTO dto : allCourses) {
            Button btn = new Button("Delete");
            CourseTM tm = new CourseTM(dto.getCode(), dto.getCourseName(),
                    dto.getCourseType(), dto.getDuration(),btn);
            tmList.add(tm);
            btn.setOnAction((e) -> {
                try {

                    ButtonType ok = new ButtonType("OK",
                            ButtonBar.ButtonData.OK_DONE);
                    ButtonType no = new ButtonType("NO",
                            ButtonBar.ButtonData.CANCEL_CLOSE);

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                            "Are You Sure ?", ok, no);
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.orElse(no) == ok) {
                        if (bo.deleteCourse(tm.getCode())) {
                            new Alert(Alert.AlertType.CONFIRMATION,
                                    "Deleted", ButtonType.OK).show();
                            loadAllCourses();
                            return;
                        }
                        new Alert(Alert.AlertType.WARNING,
                                "Try Again", ButtonType.OK).show();
                    } else {
                        //no
                    }


                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            });
        }
        tblCourse.setItems(tmList);

    }

    public void btnSaveOnAction(ActionEvent actionEvent) throws Exception {
        boolean isSaved = bo.saveCourse(
                new CourseDTO(txtCode.getText(),
                        txtCourseName.getText(),
                        txtCourseType.getText(),txtDuration.getText()
                ));

        System.out.println(isSaved);
    }
    public void getDataOnAction(ActionEvent actionEvent) throws Exception {

        CourseDTO course = bo.getCourse(txtCode.getText());
        if (course != null) {
            txtCode.setText(course.getCode());
            txtCourseName.setText(course.getCourseName());
            txtCourseType.setText(course.getCourseType());
            txtDuration.setText(course.getDuration());
        }
    }
}
