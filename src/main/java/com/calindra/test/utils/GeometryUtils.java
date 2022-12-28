package com.calindra.test.utils;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public abstract class GeometryUtils {
    public static double[][] getDistances(List<Point2D.Double> points) {
        int numPoints = points.size();
        double[][] distances = new double[numPoints][numPoints];
        for (int i = 0; i < numPoints; i++) {
            for (int j = i + 1; j < numPoints; j++) {
                Point2D.Double point1 = points.get(i);
                Point2D.Double point2 = points.get(j);
                double distance = point1.distance(point2);
                distances[i][j] = distance;
                distances[j][i] = distance;
            }
        }
        return distances;
    }


    public static List<String> getClosestPair(List<String> addresses, double[][] distances) {
        int numPoints = addresses.size();
        double minDistance = Double.MAX_VALUE;
        List<String> closestPair = null;
        for (int i = 0; i < numPoints; i++) {
            for (int j = i + 1; j < numPoints; j++) {
                double distance = distances[i][j];
                if (distance < minDistance) {
                    minDistance = distance;
                    closestPair = new ArrayList<>();
                    closestPair.add(addresses.get(i));
                    closestPair.add(addresses.get(j));
                }
            }
        }
        return closestPair;
    }

    public static List<String> getFarthestPair(List<String> addresses, double[][] distances) {
        int numPoints = addresses.size();
        double maxDistance = Double.MIN_VALUE;
        List<String> farthestPair = null;
        for (int i = 0; i < numPoints; i++) {
            for (int j = i + 1; j < numPoints; j++) {
                double distance = distances[i][j];
                if (distance > maxDistance) {
                    maxDistance = distance;
                    farthestPair = new ArrayList<>();
                    farthestPair.add(addresses.get(i));
                    farthestPair.add(addresses.get(j));
                }
            }
        }
        return farthestPair;
    }
}
