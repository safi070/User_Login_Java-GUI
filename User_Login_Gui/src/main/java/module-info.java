module com.example.user_login_gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.user_login_gui to javafx.fxml;
    exports com.example.user_login_gui;
}