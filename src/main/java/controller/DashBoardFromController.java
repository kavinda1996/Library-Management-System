package controller;

import javafx.event.ActionEvent;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;

import static javafx.fxml.FXMLLoader.load;

public class DashBoardFromController {

    public AnchorPane loadFormContent;

    public void btnCustomerFormOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/users_form.fxml");

        assert resource != null;

        Parent load = load(resource);

        loadFormContent.getChildren().clear();
        loadFormContent.getChildren().add(load);

    }
    public void btnItemFormOnAction(ActionEvent actionEvent) throws IOException{
        URL resource = this.getClass().getResource("/view/books_form.fxml");

        assert resource != null;

        Parent load = load(resource);

        loadFormContent.getChildren().clear();
        loadFormContent.getChildren().add(load);
    }

   /* public void btnOrderFormOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/borrowing_form.fxml");

        assert resource != null;

        Parent load = load(resource);

        loadFormContent.getChildren().clear();
        loadFormContent.getChildren().add(load);
    }*/

    public void btnOrderFormOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/borrowing_form.fxml");

        if (resource == null) {
            System.out.println("Error: FXML file not found!");
            return;
        }

        FXMLLoader loader = new FXMLLoader(resource);
        Parent load = load(resource);

        loadFormContent.getChildren().clear();
        loadFormContent.getChildren().add(load);
    }


    public void btnRegisterFormOnAction(ActionEvent actionEvent) throws IOException {

        URL resource = this.getClass().getResource("/view/register_form.fxml");

        assert resource != null;

        Parent load = load(resource);

        loadFormContent.getChildren().clear();
        loadFormContent.getChildren().add(load);

    }
}
