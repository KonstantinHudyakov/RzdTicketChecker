package org.khudyakov.rzd.server.service;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.khudyakov.rzd.server.SpringConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class RzdStationCodeParserTest {
    private static final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
    private static RzdStationCodeParser rzdStationCodeParser;
    private static final String STATION_NAME = "Владимир пасс";

    @BeforeClass
    public static void setupClass() {
        rzdStationCodeParser = applicationContext.getBean(RzdStationCodeParser.class);
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getStationCode() {
        String code = rzdStationCodeParser.getStationCode(STATION_NAME);
        assert code.equals("2060340");
    }
}