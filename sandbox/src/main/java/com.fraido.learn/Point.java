package com.fraido.learn;

public class Point {
    private double x;
    private double y;

    public Point() {

    }
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x-p2.x, 2)+Math.pow(p1.y-p2.y, 2));
    }

}
