package org.khudyakov.rzd.server.service;

import org.khudyakov.rzd.server.entity.RzdTrain;
import org.khudyakov.rzd.server.entity.RzdTrainsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RzdTicketCheckerImpl implements RzdTicketChecker {
    private static final String REQUEST_URL_FORMAT = "https://pass.rzd.ru/timetable/public/ru?layer_id=5827&dir=0&tfl=3&checkSeats=1&code0=%s&dt0=%s&code1=%s&dt1=%s";

    @Autowired
    private RzdTrainsParser rzdTrainsParser;
    @Autowired
    private RzdStationCodeParser rzdStationCodeParser;

    @Override
    public boolean hasTickets(String departureStationName, String arrivalStationName, String departureDate, final String departureTime) {
        String departureStationCode = rzdStationCodeParser.getStationCode(departureStationName);
        String arrivalStationCode = rzdStationCodeParser.getStationCode(arrivalStationName);

        RzdTrainsInfo trainsInfo = rzdTrainsParser.getTrainsInfo(String.format(REQUEST_URL_FORMAT, departureStationCode, departureDate, arrivalStationCode, departureDate));
        Optional<RzdTrain> train = trainsInfo.getTrains()
                .stream()
                .filter(tr -> tr.getDepartureTime().equals(departureTime))
                .findFirst();
        return train.isPresent() && train.get().isElReg();
    }
}
