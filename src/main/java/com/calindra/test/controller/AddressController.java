package com.calindra.test.controller;

import ch.qos.logback.core.joran.sanity.Pair;
import com.calindra.test.exceptions.InvalidAddressException;
import com.calindra.test.model.Address;
import com.calindra.test.response.DistanceResult;
import com.calindra.test.service.GeoapifyService;
import com.calindra.test.utils.GeometryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/calindra")
public class AddressController {
    @Autowired
    private final GeoapifyService geoapifyService;

    public AddressController(GeoapifyService geoapifyService) {
        this.geoapifyService = geoapifyService;
    }

    @PostMapping("/distance")
    public ResponseEntity<DistanceResult> getDistance(@RequestBody Address addressList) {
        List<Point2D.Double> points;
        List<String> addresses = addressList.getAddresses();
        try{
            points = geoapifyService.getCoordinates(addresses);
        } catch (InvalidAddressException e){
            return ResponseEntity.notFound().build();
        }

        double[][] distances = GeometryUtils.getDistances(points);

        List<String> closest = GeometryUtils.getClosestPair(addresses, distances);
        List<String> farthest = GeometryUtils.getFarthestPair(addresses, distances);

        return ResponseEntity.ok(new DistanceResult(distances, closest, farthest));
    }

}
