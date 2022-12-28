package com.calindra.test.utils;

//import org.junit.jupiter.api.Test;
import org.junit.Test;

import java.awt.geom.Point2D;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GeometryUtilsTest {

    @Test
    public void testGetDistances_CalindraOfficeAndRioBranco(){
        Point2D.Double calindraOffice = new Point2D.Double(-43.177989, -22.957515);
        Point2D.Double rioBranco = new Point2D.Double(-43.180204911742315, -22.89750765);
        List<Point2D.Double> pointsList = List.of(calindraOffice, rioBranco);
        double[][] distance =  GeometryUtils.getDistances(pointsList);

        assertEquals(distance[0][1], 0.06004824992347543);
    }

    @Test
    public void testGetDistances_validInput() {
        List<Point2D.Double> pointsList = List.of(
                new Point2D.Double(0, 0),
                new Point2D.Double(3, 4),
                new Point2D.Double(1, 1)
        );

        double[][] distances = GeometryUtils.getDistances(pointsList);
        assertEquals(5.0, distances[0][1], 0.001);
        assertEquals(5.0, distances[1][0], 0.001);
        assertEquals(1.414, distances[0][2], 0.001);
        assertEquals(1.414, distances[2][0], 0.001);
        assertEquals(3.605, distances[1][2], 0.001);
        assertEquals(3.605, distances[2][1], 0.001);
    }

    @Test(expected = NullPointerException.class)
    public void testGetDistances_nullInput() {
        GeometryUtils.getDistances(null);
    }

    @Test
    public void testGetDistances_emptyInput() {
        List<Point2D.Double> points = List.of();
        double[][] distances = GeometryUtils.getDistances(points);
        assertEquals(0, distances.length);
    }

    @Test
    public void testGetDistances_singlePointInput() {
        List<Point2D.Double> points = List.of(new Point2D.Double(0, 0));
        double[][] distances = GeometryUtils.getDistances(points);
        assertEquals(1, distances.length);
    }

    @Test
    public void testGetClosestPair_validInput() {
        List<String> addresses = List.of(
                "123 Rio Branco",
                "123 Voluntários da Pátria",
                "123 Rua do Catete"
        );
        double[][] distances = new double[][] {
                {0, 7.0, 5.0},
                {7.0, 0, 8.0},
                {5.0, 8.0, 0}
        };

        List<String> closestPair = GeometryUtils.getClosestPair(addresses, distances);
        assertEquals(2, closestPair.size());
        assertEquals("123 Rio Branco", closestPair.get(0));
        assertEquals("123 Rua do Catete", closestPair.get(1));
    }

    @Test(expected = NullPointerException.class)
    public void testGetClosestPair_nullAddresses() {
        double[][] distances = new double[][] {
                {0, 7.0, 5.0},
                {7.0, 0, 8.0},
                {5.0, 8.0, 0}
        };
        GeometryUtils.getClosestPair(null, distances);
    }

    @Test(expected = NullPointerException.class)
    public void testGetClosestPair_nullDistances() {
        List<String> addresses = List.of(
                "123 Rio Branco",
                "123 Voluntários da Pátria",
                "123 Rua do Catete"
        );
        GeometryUtils.getClosestPair(addresses, null);
    }

    @Test
    public void testGetClosestPair_emptyInput() {
        List<String> addresses = List.of();
        double[][] distances = new double[][] {};
        List<String> closestPair = GeometryUtils.getClosestPair(addresses, distances);
        assertNull(closestPair);
    }

    @Test
    public void testGetClosestPair_singlePointInput() {
        List<String> addresses = List.of("123 Rio Branco");
        double[][] distances = new double[][] {{0}};
        List<String> closestPair = GeometryUtils.getClosestPair(addresses, distances);
        assertNull(closestPair);
    }

    @Test
    public void testGetFarthestPair_validInput() {
        List<String> addresses = List.of(
                "123 Rio Branco",
                "123 Voluntários da Pátria",
                "123 Rua do Catete"
        );
        double[][] distances = new double[][] {
                {0, 7.0, 5.0},
                {7.0, 0, 8.0},
                {5.0, 8.0, 0}
        };

        List<String> farthestPair = GeometryUtils.getFarthestPair(addresses, distances);
        assertEquals(2, farthestPair.size());
        assertEquals("123 Voluntários da Pátria", farthestPair.get(0));
        assertEquals("123 Rua do Catete", farthestPair.get(1));
    }

    @Test(expected = NullPointerException.class)
    public void testGetFarthestPair_nullAddresses() {
        double[][] distances = new double[][] {
                {0, 5.0, 7.0},
                {5.0, 0, 8.0},
                {7.0, 8.0, 0}
        };
        GeometryUtils.getFarthestPair(null, distances);
    }

    @Test(expected = NullPointerException.class)
    public void testGetFarthestPair_nullDistances() {
        List<String> addresses = List.of(
                "123 Rio Branco",
                "123 Voluntários da Pátria",
                "123 Rua do Catete"
        );
        GeometryUtils.getFarthestPair(addresses, null);
    }

    @Test
    public void testGetFarthestPair_emptyInput() {
        List<String> addresses = List.of();
        double[][] distances = new double[][] {};
        List<String> farthestPair = GeometryUtils.getFarthestPair(addresses, distances);
        assertNull(farthestPair);
    }

    @Test
    public void testGetFarthestPair_singlePointInput() {
        List<String> addresses = List.of("123 Rio Branco");
        double[][] distances = new double[][] {{0}};
        List<String> farthestPair = GeometryUtils.getFarthestPair(addresses, distances);
        assertNull(farthestPair);
    }
}
