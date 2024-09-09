package com.company;

public class Point {
    public static boolean points;
    public static int time;

    public Point(boolean points, int time) {
        this.points = points;
        this.time = time;
    }

    public static String getPoints() {
        return String.valueOf(points);
    }

    public void setPoints(boolean points) {
        this.points = points;
    }

    public static String getTime() {
        return String.valueOf(time);
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Point{" +
                "points=" + points +
                ", time=" + time +
                '}';
    }

}
