package lk.ijse.chatApplication.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientLogingController {
    public TextField txtUserName;
    public Button btnlogin;


    static String userName ;
    public AnchorPane logg;

    public void btnloginOnAction(ActionEvent actionEvent) throws IOException {

        userName=txtUserName.getText();
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(ClientLogingController.class.getResource("/lk/ijse/chatApplication/view/ClientForm.fxml"))));
        stage.close();
        stage.centerOnScreen();
        stage.show();
    }
}
