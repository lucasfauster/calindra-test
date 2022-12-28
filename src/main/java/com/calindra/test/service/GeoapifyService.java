package com.calindra.test.service;

import com.calindra.test.exceptions.InvalidAddressException;
import com.calindra.test.model.Feature;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.calindra.test.response.GeoapifyResponse;
import org.springframework.web.util.UriComponentsBuilder;

import java.awt.geom.Point2D;
import java.net.URI;
import java.util.List;
import java.util.ArrayList;

@Service
public class GeoapifyService {

    private static final String GEOCODING_API_URL = "https://api.geoapify.com/v1/geocode/search";
    private final String apiKey = "e7032be7d8fd4349b0b58c491b354110";
    private final RestTemplate restTemplate = new RestTemplate();


    public List<Point2D.Double> getCoordinates(List<String> addresses) throws InvalidAddressException {
        List<Point2D.Double> points = new ArrayList<>();
        for (String address : addresses) {
            URI targetUrl= UriComponentsBuilder.fromUriString(GEOCODING_API_URL)
                    .queryParam("apiKey", apiKey)
                    .queryParam("text", address)
                    .build()
                    .encode()
                    .toUri();
            GeoapifyResponse response = restTemplate.getForObject(targetUrl, GeoapifyResponse.class);
            if (response != null && response.getFeatures() != null && !response.getFeatures().isEmpty()) {
                Feature feature = response.getFeatures().get(0);
                points.add(new Point2D.Double(feature.getGeometry().getCoordinates().get(0), feature.getGeometry().getCoordinates().get(1)));
            }else{
                throw new InvalidAddressException("Invalid address format.");
            }
        }
        return points;
    }

}
