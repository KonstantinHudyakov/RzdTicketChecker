package org.khudyakov.rzd.server.service;

public interface RzdTicketChecker {
    boolean hasTickets(String departureStationName, String arrivalStationName, String departDate, String departTime);
}
