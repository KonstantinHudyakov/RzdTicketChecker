package org.khudyakov.rzd.server.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RzdTrainsInfo {
    private String from;
    private String fromCode;
    private String where;
    private String whereCode;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate date;

    @JsonProperty("list")
    private RzdTrainsList trains;

    public RzdTrainsInfo() {
    }

    public RzdTrainsInfo(String from, String fromCode, String where, String whereCode, LocalDate date, RzdTrainsList trains) {
        this.from = from;
        this.fromCode = fromCode;
        this.where = where;
        this.whereCode = whereCode;
        this.date = date;
        this.trains = trains;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFromCode() {
        return fromCode;
    }

    public void setFromCode(String fromCode) {
        this.fromCode = fromCode;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getWhereCode() {
        return whereCode;
    }

    public void setWhereCode(String whereCode) {
        this.whereCode = whereCode;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public RzdTrainsList getTrains() {
        return trains;
    }

    public void setTrains(RzdTrainsList trains) {
        this.trains = trains;
    }
}
