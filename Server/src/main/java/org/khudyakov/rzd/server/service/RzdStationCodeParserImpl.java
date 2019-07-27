package org.khudyakov.rzd.server.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.khudyakov.rzd.server.entity.RzdStation;
import org.khudyakov.rzd.server.entity.RzdStationsList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Optional;

@Service
public class RzdStationCodeParserImpl implements RzdStationCodeParser {
    private static final String REQUEST_URL = "https://pass.rzd.ru/suggester?compactMode=y&lang=ru&stationNamePart=";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String getStationCode(String stationName) {
        final String upperStationName = stationName.toUpperCase();
        ResponseEntity<String> response = restTemplate.getForEntity(REQUEST_URL + upperStationName, String.class);
        RzdStationsList stationsList = mapToObject(response.getBody());
        Optional<RzdStation> station =  stationsList.stream()
                .filter(st -> st.getName().equals(upperStationName))
                .findFirst();
        return station.isPresent() ? station.get().getCode() : null;
    }

    private RzdStationsList mapToObject(String response) {
        ObjectMapper objectMapper = new ObjectMapper();
        RzdStationsList stationsList = null;
        try {
            JsonNode root = objectMapper.readTree(response);
            stationsList = objectMapper.treeToValue(root, RzdStationsList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stationsList;
    }
}
