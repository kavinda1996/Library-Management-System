package controller.books;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class BooksFormController {

    @FXML
    private TableColumn colId;

    @FXML
    private TableColumn colName;

    @FXML
    private TableColumn colPrice;

    @FXML
    private TableColumn colQuantity;

    @FXML
    private TableView tblItem;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtQuantity;

    private BooksDetailController itemDetailController = new BooksDetailController();

    @FXML
    void btnAddOnAction(ActionEvent event) {
        // Get values from text fields
        String code = txtId.getText();
        String description = txtName.getText();
        double unitPrice;
        int qtyOnHand;

        try {
            unitPrice = Double.parseDouble(txtPrice.getText());
            qtyOnHand = Integer.parseInt(txtQuantity.getText());
        } catch (NumberFormatException e) {
            showAlert("Error", "Invalid price or quantity!", Alert.AlertType.ERROR);
            return;
        }

        // Call addItem method in ItemDetailController
        boolean isAdded = itemDetailController.addItem(code, description, unitPrice, qtyOnHand);

        if (isAdded) {
            showAlert("Success", "✅ Item added successfully!", Alert.AlertType.INFORMATION);
            clearFields(); // Clear input fields after adding
        } else {
            showAlert("Failed", "❌ Failed to add item!", Alert.AlertType.ERROR);
        }
    }

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearFields() {
        txtId.clear();
        txtName.clear();
        txtPrice.clear();
        txtQuantity.clear();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        // Implement delete function
    }

    @FXML
    void btnReloadOnAction(ActionEvent event) {
        // loadTable();
    }



    @FXML
    void btnSearchOnAction(ActionEvent event) {
        // Implement search function
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        // Implement update function
    }
}
