package main.java.com.jenil;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateEmployeeController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField positionField;
    @FXML
    private TextField salaryField;

    @FXML
    private void handleCreateButton() {
        String name = nameField.getText();
        String position = positionField.getText();
        double salary = Double.parseDouble(salaryField.getText());

        try {
            Connection connection = DatabaseConnector.getConnection();
            String insertQuery = "INSERT INTO employees (name, position, salary) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, position);
            preparedStatement.setDouble(3, salary);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database error
        }
    }
}
