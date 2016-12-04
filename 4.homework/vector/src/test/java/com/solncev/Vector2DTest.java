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
    private static final Vector2D VECTOR_1 = new Vector2D(X, Y);
    private static final Vector2D VECTOR_2 = new Vector2D(X, Y);
    private static final String ANSWER = "(" + X + "," + Y + ")";
    private static final Vector2D VECTOR_SUM = new Vector2D(2 * X, 2 * Y);

    @Test
    public void getXShouldReturnCorrectX() {
        Assert.assertEquals(X, VECTOR_1.getX(), DELTA);
    }

    @Test
    public void getYShouldReturnCorrectY() {
        Assert.assertEquals(Y, VECTOR_1.getY(), DELTA);
    }

    @Test
    public void sumShouldShouldReturnCorrectSum() {
        Assert.assertTrue(VECTOR_SUM.equals(VECTOR_1.sum(VECTOR_2)));
    }

    @Test
    public void lengthShouldReturnCorrectLength() {
        Assert.assertEquals(Math.sqrt(X * X + Y * Y), VECTOR_1.length(), DELTA);
    }

    @Test
    public void scalarProductShouldReturnCorrectScalarProduct() {
        Assert.assertEquals(X * X + Y * Y, VECTOR_1.scalarProduct(VECTOR_2), DELTA);
    }

    @Test
    public void equalsShouldReturnTrue() {
        Assert.assertTrue(VECTOR_1.equals(VECTOR_2));
    }

    @Test
    public void equalsShouldReturnFalse() {
        Assert.assertFalse(VECTOR_1.equals(VECTOR_SUM));
    }

    @Test
    public void toStringShouldReturnCorrectString() {
        Assert.assertTrue(VECTOR_1.toString().equals(ANSWER));
    }
}
