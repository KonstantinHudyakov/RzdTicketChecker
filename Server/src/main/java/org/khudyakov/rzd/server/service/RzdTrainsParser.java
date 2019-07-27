package org.khudyakov.rzd.server.service;

import org.khudyakov.rzd.server.entity.RzdRequestId;
import org.khudyakov.rzd.server.entity.RzdTrainsInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public interface RzdTrainsParser {
    RzdTrainsInfo getTrainsInfo(String url);
}
