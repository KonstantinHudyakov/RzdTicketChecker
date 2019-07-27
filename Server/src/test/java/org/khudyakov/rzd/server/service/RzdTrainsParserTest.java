package org.khudyakov.rzd.server.service;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.khudyakov.rzd.server.SpringConfiguration;
import org.khudyakov.rzd.server.entity.RzdTrainsInfo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class RzdTrainsParserTest {
    private static final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
    private static RzdTrainsParser ticketChecker;
    private static final String URL = "https://pass.rzd.ru/timetable/public/ru?layer_id=5827&dir=0&tfl=3&checkSeats=1&code0=2000001&dt0=02.08.2019&code1=2060340&dt1=02.08.2019";

    @BeforeClass
    public static void setupClass() {
        ticketChecker = applicationContext.getBean(RzdTrainsParserImpl.class);
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getTrainsInfo() throws IOException, InterruptedException {
        RzdTrainsInfo trainsInfo = ticketChecker.getTrainsInfo(URL);
        assert trainsInfo != null;
    }
}