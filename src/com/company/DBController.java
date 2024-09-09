package com.company;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.sql.*;


public class DBController {
    private static String CONN = "jdbc:sqlite:points2.db";


    public static void add() {
        try {
            Connection connection = DriverManager.getConnection(CONN);
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), event -> {
                Point.time += 1;
                Room1.Walls.setOnMouseClicked(event1 -> {
                    Point.points = true;
                });
                String sql = "INSERT INTO points(points,time) VAlUES (?, ?)";
                PreparedStatement ps = null;
                try {
                    ps = connection.prepareStatement(sql);
                    ps.setString(1, Point.getPoints());
                    ps.setString(2, Point.getTime());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }));
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();

            String sql2 = "SELECT points" + "FROM points" + "ORDER BY rowid DESC " + "LIMIT 1";
            PreparedStatement ps = null;
            ps = connection.prepareStatement(sql2);
            Ending.points.setText(String.valueOf(ps));
            String sql3 = "SELECT time" + "FROM points" + "ORDER BY rowid DESC " + "LIMIT 1";
            PreparedStatement ps2 = null;
            ps2 = connection.prepareStatement(sql3);
            Ending.seconds.setText(String.valueOf(ps2));
            ps.executeLargeUpdate();
            connection.close();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}


