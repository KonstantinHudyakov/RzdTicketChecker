package org.khudyakov.rzd.server.service;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.khudyakov.rzd.server.SpringConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class RzdTicketCheckerTest {
    private static final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
    private static RzdTicketChecker rzdTicketChecker;
    private static final String DEPARTURE_STATION_NAME = "Москва Курская (Курский Вокзал)";
    private static final String ARRIVAL_STATION_NAME = "Владимир пасс";
    private static final String DEPARTURE_DATE = "02.08.2019";
    private static final String DEPARTURE_TIME = "18:23";


    @BeforeClass
    public static void setupClass() {
        rzdTicketChecker = applicationContext.getBean(RzdTicketChecker.class);
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void hasTickets() {
        boolean result = rzdTicketChecker.hasTickets(DEPARTURE_STATION_NAME, ARRIVAL_STATION_NAME, DEPARTURE_DATE, DEPARTURE_TIME);
        assert !result;
    }
}