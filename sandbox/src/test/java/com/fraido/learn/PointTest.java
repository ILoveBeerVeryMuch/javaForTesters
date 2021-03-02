package com.fraido.learn;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {
    Point point = new Point();

    @Test
    public void testDistancePointPositive() {
        Assert.assertEquals(point.distance(new Point(25.0, 0.0), new Point(16.0, 0.0)), 9.00);
    }

    @Test
    public void testDistancePointWithNull() {
        Assert.assertEquals(point.distance(new Point(0.0, 0.0), new Point(0.0, 0.0)), 0.00);
    }

    @Test
    public void testDistancePointStringFormat() {
        Assert.assertEquals(String.format("%.2f",point.distance(new Point(1.0, 2.0), new Point(3.0, 4.0))), "2,83");
    }

}
