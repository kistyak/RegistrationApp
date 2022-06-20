package net.kistyak.registrationwin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField CountryField;

    @FXML
    private TextField NameField;

    @FXML
    private RadioButton RudioButtonFemale;

    @FXML
    private RadioButton RudioButtonMale;

    @FXML
    private Button SignUpButton;

    @FXML
    private TextField SignUpLoginField;

    @FXML
    private PasswordField SignUpPasswordField;

    @FXML
    private TextField SurnameField;

    @FXML
    void initialize() {

    }

}
