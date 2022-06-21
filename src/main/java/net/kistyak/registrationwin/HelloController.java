package net.kistyak.registrationwin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField LoginField;

    @FXML
    private PasswordField PasswordField;

    @FXML
    private Button SignInButton;

    @FXML
    private Button SignUpButton;

    @FXML
    void initialize() {

        SignInButton.setOnAction(event -> {
            String loginText = LoginField.getText().trim();
            String passText = PasswordField.getText().trim();

            if(!loginText.equals("") && !passText.equals("")){
                loginUser(loginText, passText);
            }
            else
                System.out.println("Empty field");
        });

        SignUpButton.setOnAction(event -> {
            SignUpButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("sign_up.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }

    private void loginUser(String loginText, String passText) {

    }

}
