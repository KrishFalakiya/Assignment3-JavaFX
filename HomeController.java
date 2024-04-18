package main.java.com.jenil;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

    @FXML
    private void openUpdateWindow() throws IOException {
        openWindow("UpdateEmployee.fxml", "Update Employee Salary");
    }

    @FXML
    private void openCreateWindow() throws IOException {
        openWindow("CreateEmployee.fxml", "Create New Employee");
    }

    @FXML
    private void openDeleteWindow() throws IOException {
        openWindow("DeleteEmployee.fxml", "Delete Employee");
    }

    private void openWindow(String fxmlFile, String title) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
        stage.setTitle(title);
        stage.setScene(new Scene(root, 400, 300));
        stage.show();
    }
}
