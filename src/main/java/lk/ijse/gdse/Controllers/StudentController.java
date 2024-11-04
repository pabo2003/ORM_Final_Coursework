package lk.ijse.gdse.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lk.ijse.gdse.BO.Impl.BOFactory;
import lk.ijse.gdse.BO.StudentBO;
import lk.ijse.gdse.DTO.StudentDTO;
import lk.ijse.gdse.DTO.UserDTO;
import lk.ijse.gdse.util.PasswordEncrypt;
import lk.ijse.gdse.util.PasswordVerifier;

import java.sql.SQLException;
import java.util.List;

public class StudentController {

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPhoneNumber;

    @FXML
    private TableColumn<?, ?> colStudentID;

    @FXML
    private TextField txtId;


    @FXML
    private TableView<StudentDTO> tblStudents;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhoneNumber;

    StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBo(BOFactory.BoType.Student);

    public void initialize(){
        setCellValueFactory();
        loadAll();

        tblStudents.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                txtId.setText(newSelection.getStu_id());
                txtName.setText(newSelection.getStu_name());
                txtPhoneNumber.setText(newSelection.getStu_phone());
                txtEmail.setText(newSelection.getStu_email());
                txtAddress.setText(newSelection.getStu_address());
            }
        });
    }

    private void setCellValueFactory() {
        colStudentID.setCellValueFactory(new PropertyValueFactory<>("stu_id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("stu_name"));
        colPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("stu_phone"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("stu_email"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("stu_address"));
    }

    private void loadAll() {
        ObservableList<StudentDTO> obList = FXCollections.observableArrayList();
        try {
            List<StudentDTO> studentDTOList = studentBO.getAll();
            for (StudentDTO studentDTO : studentDTOList) {
                StudentDTO tm = new StudentDTO(
                        studentDTO.getStu_id(),
                        studentDTO.getStu_name(),
                        studentDTO.getStu_phone(),
                        studentDTO.getStu_email(),
                        studentDTO.getStu_address()
                );

                obList.add(tm);
            }

            tblStudents.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
//            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        try {
            String id = txtId.getText().trim();
            String name = txtName.getText().trim();
            String phone = txtPhoneNumber.getText().trim();
            String email = txtEmail.getText().trim();
            String address = txtAddress.getText().trim();

            if (id.isEmpty() || name.isEmpty() || phone.isEmpty() || email.isEmpty() || address.isEmpty()) {
                new Alert(Alert.AlertType.WARNING, "Please fill in all fields!").show();
                return;
            }

            StudentDTO studentDTO = new StudentDTO(id, name, phone, email, address);

            boolean isSaved = studentBO.save(studentDTO);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Student saved successfully!").show();
                clear();
                loadAll();
            } else {
                new Alert(Alert.AlertType.ERROR, "Student not saved successfully!").show();
            }
        } catch (Exception ex) {
            new Alert(Alert.AlertType.ERROR, "An error occurred: " + ex.getMessage()).show();
            ex.printStackTrace();
        }
    }


    private void clear() {
        txtId.clear();
        txtName.clear();
        txtPhoneNumber.clear();
        txtEmail.clear();
        txtAddress.clear();
    }
    @FXML
    void btnBackOnAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DashBoard.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) btnBack.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.centerOnScreen();
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clear();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtId.getText();

        try {
            boolean isDeleted = studentBO.delete(id);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Student deleted successfully!").show();
                clear();
                loadAll();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to delete student!").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "An error occurred: " + e.getMessage()).show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        try {
            String id = txtId.getText();
            String name = txtName.getText();
            String address = txtPhoneNumber.getText();
            String phone = txtEmail.getText();
            String email = txtAddress.getText();

            StudentDTO studentDTO = new StudentDTO(id, name, phone, email, address);


            boolean isUpdate = studentBO.save(studentDTO);
            if (isUpdate) {
                new Alert(Alert.AlertType.CONFIRMATION, "Student update successfully!").show();
                clear();
                loadAll();

            } else {
                new Alert(Alert.AlertType.ERROR, "Student not update successfully!").show();
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
