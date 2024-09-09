package com.company;


import javafx.fxml.FXML;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javafx.scene.shape.Rectangle;

import java.io.IOException;



public class Room1 {

    @FXML
    public static ImageView Walls;

    @FXML
    private ImageView RolledCarpet;

    @FXML
    private Rectangle Hole;

    @FXML
    private ImageView LadderInHole;
    @FXML
    private ImageView Ladder;

    @FXML
    private ImageView Carpet;

    @FXML
    private ImageView Wordobe;
    @FXML
    private ImageView openChest;

    @FXML
    private ImageView Chest;

    @FXML
    private ImageView Table;

    @FXML
    private TextField Code;
    @FXML
    private ImageView Lom;



    @FXML
    void rec(MouseEvent event) {
        Code.setVisible(true);
    }

    @FXML
    void points(MouseEvent event) {
        DBController.add();

    }

    @FXML
    private void code() {
        String userImput = Code.getText();

        if (userImput.equals("10619")) {
            Lom.setVisible(true);
            Chest.setVisible(false);


        }


    }




    @FXML
    void moveLom(MouseEvent event) {

            Lom.setOnMouseDragged(event1 -> {

                Lom.setTranslateX(event1.getSceneX() -400);
                Lom.setTranslateY(event1.getSceneY()-400);


            });

            Lom.setOnMouseReleased(event1 -> {
               if((Lom.getTranslateX() - Wordobe.getLayoutX()) <1000 && Math.abs(Lom.getTranslateY() - Wordobe.getLayoutY()) < 1000){
                   Wordobe.setVisible(false);
                   Ladder.setVisible(true);

               }
            });


    }

    @FXML
    void moveCarpet(MouseEvent event) {
        Carpet.setOnMouseClicked(event2 ->{
            Carpet.setVisible(false);
            RolledCarpet.setVisible(true);

        });

    }
    @FXML
    void moveLadder(MouseEvent event) {

        Ladder.setOnMouseDragged(event3 -> {


            Ladder.setTranslateX(event3.getSceneX());
            Ladder.setTranslateY(event3.getSceneY()-200);


        });
        Ladder.setOnMouseReleased(event3 -> {
            if(Math.abs(Ladder.getTranslateX() - Hole.getLayoutX()) <1000 && Math.abs(Ladder.getTranslateY() - Hole.getLayoutY()) < 1000 && !Carpet.isVisible()){
                Ladder.setVisible(false);
                LadderInHole.setVisible(true);
                AnchorPane root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("ending.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Main.stage.setScene(new Scene(root));

            }

        });

    }


}








