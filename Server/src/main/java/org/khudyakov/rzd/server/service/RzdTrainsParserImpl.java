package org.khudyakov.rzd.server.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.khudyakov.rzd.server.entity.RzdRequestId;
import org.khudyakov.rzd.server.entity.RzdTrainsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Service
public class RzdTrainsParserImpl implements RzdTrainsParser {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public RzdTrainsInfo getTrainsInfo(String url) {
        ResponseEntity<RzdRequestId> registrationResponse = restTemplate.getForEntity(url, RzdRequestId.class);
        List<String> cookies = registrationResponse.getHeaders()
                .get(HttpHeaders.SET_COOKIE);
        String rid = registrationResponse.getBody()
                .getRid();

        HttpEntity requestEntity = createRequestEntity(cookies);

        sleep(1000);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url + "&rid=" + rid, HttpMethod.GET, requestEntity, String.class);
        return mapToInfo(responseEntity.getBody());
    }

    private HttpEntity createRequestEntity(List<String> cookies) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.addAll(HttpHeaders.COOKIE, cookies);
        return new HttpEntity(requestHeaders);
    }

    private RzdTrainsInfo mapToInfo(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        RzdTrainsInfo trainsInfo = null;
        try {
            JsonNode root = objectMapper.readTree(json);
            ObjectNode info = (ObjectNode) root.get("tp").get(0);
            trainsInfo = objectMapper.treeToValue(info, RzdTrainsInfo.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return trainsInfo;
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
