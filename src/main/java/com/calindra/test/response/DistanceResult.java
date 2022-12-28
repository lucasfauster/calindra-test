package com.calindra.test.response;

import java.util.List;

public class DistanceResult {
    private double[][] distances;
    private List<String> closest;
    private List<String> farthest;

    public DistanceResult(double[][] distances, List<String> closest, List<String> farthest) {
        this.distances = distances;
        this.closest = closest;
        this.farthest = farthest;
    }

    public double[][] getDistances() {
        return distances;
    }

    public List<String> getClosest() {
        return closest;
    }

    public List<String> getFarthest() {
        return farthest;
    }

    public void setDistances(double[][] distances) {
        this.distances = distances;
    }

    public void setClosest(List<String> closest) {
        this.closest = closest;
    }

    public void setFarthest(List<String> farthest) {
        this.farthest = farthest;
    }
}
