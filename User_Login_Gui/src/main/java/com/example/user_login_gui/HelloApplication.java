package com.example.user_login_gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override


    // Name:   M.Safi-Ur-Rehman
    // Reg No: SP24-BSE-083
    public void start(Stage stage) throws IOException {

        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));


        BorderPane mainLayout=new BorderPane();

        FileInputStream banner =new FileInputStream("D:\\Java Programes\\IntelliJ Idea\\User_Login_Gui\\Image\\login.png");
        Image bannerImage =new Image(banner);
        ImageView bannerImageView= new ImageView(bannerImage);
        mainLayout.setTop(bannerImageView);
        bannerImageView.setFitHeight(110);
        bannerImageView.setFitWidth(110);
        bannerImageView.setPreserveRatio(true);

        GridPane formLayout = new GridPane();
        formLayout.setPadding(new Insets(20));
        formLayout.setHgap(10);
        formLayout.setVgap(10);

        formLayout.add(new Label(" UserName:"), 0, 0);
        TextField userNameField = new TextField();
        formLayout.add(userNameField, 1, 0);

        formLayout.add(new Label("Password:"), 0, 1);
        TextField passwordField = new TextField();
        formLayout.add(passwordField, 1, 1);

//        LoginData.readFromFile(userNameField,passwordField);
        Button signIn = new Button("Sign IN");
        formLayout.add(signIn, 1, 2);
        signIn.setOnAction(e -> {
            // Get the text from the TextField and store it in a string variable
            String userName = userNameField.getText();
            String password= passwordField.getText();

            try {
                String user =LoginData.validateUser(userName,password);
                if (user.equals("No User has such User name and Password")){
                    Label noUserFound=new Label("Invalid User name or Password");
                    formLayout.add(noUserFound, 1,4);
                }
                else {
//                    Stage stage1=new Stage();
//                    BorderPane mainlayout1= new BorderPane();
//                    GridPane formLayout1 = new GridPane();
//                    formLayout1.add(new Label(" Welcome " + userName), 3, 3);
//
//                    Scene scene1 =new Scene(mainlayout1,600,400);
//
//                    stage1.setTitle("New User Login");
//                    stage1.setScene(scene1);
//                    stage1.show();

                    newUserWindow(userName);


                }



            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }


        });


        Button exit = new Button("Exit");
        formLayout.add(exit, 2, 2);
        exit.setOnAction(e-> stage.hide());

        Label signUpLable=new Label("Don't have a account ?");
        formLayout.add(signUpLable, 1, 3);

        Button signUp = new Button("Sign Up");
        formLayout.add(signUp, 2, 3);
        signUp.setOnAction(e-> stage.hide());


        // Formatting ...................
        mainLayout.setPadding(new Insets(80,80,80,80));
        mainLayout.setCenter(formLayout);

        Scene scene = new Scene(mainLayout, 600, 400);
        stage.setTitle("User_Login   produced by M. Safi-Ur-Rehman (SP24-BSE-083)");
        stage.setScene(scene);
        stage.show();
    }


    protected void newUserWindow(String userName){
        // Create a new stage for the welcome window
        Stage stage1 = new Stage();

        // Create a new layout for the welcome window (GridPane)
        BorderPane mainLayout1 = new BorderPane();
        GridPane formLayout1 = new GridPane();
        formLayout1.setPadding(new Insets(20));
        formLayout1.setHgap(10);
        formLayout1.setVgap(10);

        // Add a label with the welcome message
        formLayout1.add(new Label("Welcome " + userName), 0, 0);

        // Set up the scene for the welcome window
        Scene scene1 = new Scene(mainLayout1, 600, 400);
        mainLayout1.setCenter(formLayout1);

        // Set up the stage
        stage1.setTitle("Welcome " + userName);
        stage1.setScene(scene1);
        stage1.show();

    }

    public static void main(String[] args) {
        launch();
    }
}