package com.solncev;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Марат on 03.12.2016.
 */
public class Vector2DTest {
    private static final double X = 1.0d;
    private static final double Y = 2.0d;
    private static final double DELTA = 10e-5;
    private static final Vector2D VECTOR1 = new Vector2D(X, Y);
    private static final Vector2D VECTOR2 = new Vector2D(X, Y);
    private static final String ANSWER = "(" + X + "," + Y + ")";
    private static final Vector2D VECTOR_SUM = new Vector2D(2 * X, 2 * Y);

    @Test
    public void getXShouldReturnCorrectX() {
        Assert.assertEquals(X, VECTOR1.getX(), DELTA);
    }

    @Test
    public void getYShouldReturnCorrectY() {
        Assert.assertEquals(Y, VECTOR1.getY(), DELTA);
    }

    @Test
    public void sumShouldShouldReturnCorrectSum() {
        Assert.assertTrue(VECTOR_SUM.equals(VECTOR1.sum(VECTOR2)));
    }

    @Test
    public void lengthShouldReturnCorrectLength() {
        Assert.assertEquals(Math.sqrt(X * X + Y * Y), VECTOR1.length(), DELTA);
    }

    @Test
    public void scalarProductShouldReturnCorrectScalarProduct() {
        Assert.assertEquals(X * X + Y * Y, VECTOR1.scalarProduct(VECTOR2), DELTA);
    }

    @Test
    public void equalsShouldReturnTrue() {
        Assert.assertTrue(VECTOR1.equals(VECTOR2));
    }

    @Test
    public void equalsShouldReturnFalse() {
        Assert.assertFalse(VECTOR1.equals(VECTOR_SUM));
    }

    @Test
    public void toStringShouldReturnCorrectString() {
        Assert.assertTrue(VECTOR1.toString().equals(ANSWER));
    }
}
