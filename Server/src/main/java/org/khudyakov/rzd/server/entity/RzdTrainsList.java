package org.khudyakov.rzd.server.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.ArrayList;

@JsonFormat(shape= JsonFormat.Shape.ARRAY)
public class RzdTrainsList extends ArrayList<RzdTrain> {

}
