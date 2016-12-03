package com.solncev;

/**
 * Created by Марат on 03.12.2016.
 */
public class Vector2D {
    private double x;
    private double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Vector2D sum(Vector2D v) {
        return new Vector2D(x + v.getX(), y + v.getY());
    }

    public double length() {
        return Math.sqrt(x * x + y * y);
    }

    public double scalarProduct(Vector2D v) {
        return this.x * v.getX() + this.y * v.getY();
    }

    public boolean equals(Vector2D v) {
        return this.x == v.getX() && this.y == v.getY();
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
