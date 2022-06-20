module net.kistyak.registrationwin {
    requires javafx.controls;
    requires javafx.fxml;


    opens net.kistyak.registrationwin to javafx.fxml;
    exports net.kistyak.registrationwin;
}