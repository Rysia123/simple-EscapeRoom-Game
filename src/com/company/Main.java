package com.company;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    static Stage stage;

    public static void main(String[] args) {
	launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.setTitle("Escape Room");


        AnchorPane root = FXMLLoader.load(getClass().getResource("room1.fxml")) ;
        stage.setScene(new Scene(root));



        stage.show();
    }
}
