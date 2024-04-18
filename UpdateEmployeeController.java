package main.java.com.jenil;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateEmployeeController {

    @FXML
    private TextField employeeIdField;
    @FXML
    private TextField incrementField;

    @FXML
    private void handleUpdateButton() {
        int employeeId = Integer.parseInt(employeeIdField.getText());
        double percentIncrement = Double.parseDouble(incrementField.getText());

        try {
            Connection connection = DatabaseConnector.getConnection();
            String updateQuery = "UPDATE employees SET salary = salary + (salary * ? / 100) WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setDouble(1, percentIncrement);
            preparedStatement.setInt(2, employeeId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database error
        }
    }
}
