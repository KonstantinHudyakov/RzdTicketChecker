package org.khudyakov.rzd.server.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class TicketCheckerImpl implements TicketChecker {
    private RestTemplate restClient;

    public TicketCheckerImpl() {
        restClient = new RestTemplate();
//        MappingJackson2HttpMessageConverter messageConverter =
//                new MappingJackson2HttpMessageConverter(new ObjectMapper());
//        restClient.setMessageConverters(Collections.singletonList(messageConverter));
    }

    public String getRID(String url) {
        String rid = "";
  //      try {
            ResponseEntity<String> response = restClient.getForEntity(url, String.class);
            String result = response.getBody();

//            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//            String line = reader.readLine();
//            while ("".equals(line))
//                line = reader.readLine();
//
//            String[] pairs = line.split(",");
//            String[] ridPair = pairs[1].split(":");
//
//            rid = ridPair[1];
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return rid;
    }
}
