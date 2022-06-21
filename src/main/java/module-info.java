module net.kistyak.registrationwin {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens net.kistyak.registrationwin to javafx.fxml;
    exports net.kistyak.registrationwin;
}