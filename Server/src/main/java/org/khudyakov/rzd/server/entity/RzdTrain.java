package org.khudyakov.rzd.server.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RzdTrain {
    private String number;

    private boolean elReg;

    @JsonProperty("station0")
    private String departurePlace;

    @JsonProperty("station1")
    private String arrivalPlace;

    @JsonProperty("routeCode0")
    private String departureCode;

    @JsonProperty("routeCode1")
    private String arrivalCode;

    @JsonProperty("date0")
    private String date;

    @JsonProperty("time0")
    private String departureTime;

    @JsonProperty("time1")
    private String arrivalTime;

    private String timeInWay;

    public RzdTrain() {
    }

    public RzdTrain(String number, boolean elReg, String departurePlace, String arrivalPlace, String departureCode, String arrivalCode, String date, String departureTime, String arrivalTime, String timeInWay) {
        this.number = number;
        this.elReg = elReg;
        this.departurePlace = departurePlace;
        this.arrivalPlace = arrivalPlace;
        this.departureCode = departureCode;
        this.arrivalCode = arrivalCode;
        this.date = date;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.timeInWay = timeInWay;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isElReg() {
        return elReg;
    }

    public void setElReg(boolean elReg) {
        this.elReg = elReg;
    }

    public String getDeparturePlace() {
        return departurePlace;
    }

    public void setDeparturePlace(String departurePlace) {
        this.departurePlace = departurePlace;
    }

    public String getArrivalPlace() {
        return arrivalPlace;
    }

    public void setArrivalPlace(String arrivalPlace) {
        this.arrivalPlace = arrivalPlace;
    }

    public String getDepartureCode() {
        return departureCode;
    }

    public void setDepartureCode(String departureCode) {
        this.departureCode = departureCode;
    }

    public String getArrivalCode() {
        return arrivalCode;
    }

    public void setArrivalCode(String arrivalCode) {
        this.arrivalCode = arrivalCode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getTimeInWay() {
        return timeInWay;
    }

    public void setTimeInWay(String timeInWay) {
        this.timeInWay = timeInWay;
    }
}
