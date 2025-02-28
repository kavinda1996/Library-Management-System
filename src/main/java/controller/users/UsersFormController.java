package controller.users;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Users;
import service.BoFactory;
import service.custom.UsersBo;
import util.BoType;

public class UsersFormController {

    @FXML
    private TableColumn colAddress;

    @FXML
    private TableColumn colId;

    @FXML
    private TableColumn colName;

    @FXML
    private TableColumn colEmail;

    @FXML
    private TableView tblUsers;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtEmail;


    UsersBo customerBo = BoFactory.getInstance().getBoType(BoType.CUSTOMER);

    @FXML
    void btnAddOnAction(ActionEvent event) {

        boolean isCustomerAdd = customerBo.addCustomer(
                new Users(
                        txtId.getText(),
                        txtName.getText(),
                        txtAddress.getText(),
                        txtEmail.getText()

                )
        );

        if (isCustomerAdd){
            new Alert(Alert.AlertType.INFORMATION,"User Added!!").show();
        }else{
            new Alert(Alert.AlertType.ERROR,"User Not Added!!").show();

        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnReloadOnAction(ActionEvent event) {
        loadTable();
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
    }

    private void loadTable() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        ObservableList<Users> customerObservableList = FXCollections.observableArrayList();
//        List<Customer> all = new CustomerController().getAll();
//        all.forEach(customer -> {
//            customerObservableList.add(customer);
//        });
//
//        tblCustomers.setItems(customerObservableList);
    }

    public TableView getTblUsers() {
        return tblUsers;
    }

    public void setTblUsers(TableView tblUsers) {
        this.tblUsers = tblUsers;
    }
}
