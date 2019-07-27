package org.khudyakov.rzd.server.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.ArrayList;

@JsonFormat(shape= JsonFormat.Shape.ARRAY)
public class RzdStationsList extends ArrayList<RzdStation> {
}
