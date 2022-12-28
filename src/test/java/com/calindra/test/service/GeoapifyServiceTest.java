package com.calindra.test.service;

import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeoapifyServiceTest {

    GeoapifyService geoapifyService = new GeoapifyService();

    @Test
    public void getCoordinates_CalindraOffice() {
        String officeAddress = "Rua Mauro Muller 116, Botafogo, Rio de Janeiro,RJ, 22290160";
        List<String> addressesList = new ArrayList<>();
        List<Point2D.Double> coordinates = null;
        addressesList.add(officeAddress);

        try {
            coordinates = geoapifyService.getCoordinates(addressesList);
        } catch (Exception ignored){}

        assert coordinates != null;
        Point2D.Double point = coordinates.get(0);
        assertEquals(point.x, -43.177989);
        assertEquals(point.y, -22.957515);
    }
}
