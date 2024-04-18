package main.java.com.jenil;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteEmployeeController {

    @FXML
    private TextField employeeIdField;

    @FXML
    private void handleDeleteButton() {
        int employeeId = Integer.parseInt(employeeIdField.getText());

        try {
            Connection connection = DatabaseConnector.getConnection();
            String deleteQuery = "DELETE FROM employees WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, employeeId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database error
        }
    }
}
