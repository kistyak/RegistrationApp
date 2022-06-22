package net.kistyak.registrationwin;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import net.kistyak.registrationwin.animations.Shake;
import org.w3c.dom.Node;

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
            NewScene("sign_up.fxml");
        });
    }

    private void loginUser(String loginText, String passText) {
        DataBaseHandler dbHandler = new DataBaseHandler() ;
        Users user = new Users();
        user.setUserName(loginText);
        user.setPassword(passText);
        ResultSet result = dbHandler.getUser(user);

        int counter = 0;
        while (true) {
            try {
                if (!result.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            counter++;
        }

        if(counter >= 1){

            NewScene("sign_in.fxml");

        }else {
            Shake userLoginAnimation = new Shake(LoginField);
            Shake userPassAnimation = new Shake(PasswordField);
            userLoginAnimation.playAnimation();
            userPassAnimation.playAnimation();
        }
    }

    public void NewScene(String window){
        SignUpButton.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));

        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
}
