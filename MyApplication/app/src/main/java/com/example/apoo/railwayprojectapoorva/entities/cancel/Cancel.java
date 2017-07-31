package com.example.apoo.railwayprojectapoorva.entities.cancel;

/**
 * Created by Apoo on 7/18/2017.
 */

public class Cancel {

    String trainName;
    String sourceStationName;
    String destinationName;
    String trainNumber;
    String type;
    String startTime;


    public Cancel(String trainName, String sourceStationName, String destinationName, String trainNumber, String type, String startTime) {
        this.trainName = trainName;
        this.sourceStationName = sourceStationName;
        this.destinationName = destinationName;
        this.trainNumber = trainNumber;
        this.type = type;
        this.startTime = startTime;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getSourceStationName() {
        return sourceStationName;
    }

    public void setSourceStationName(String sourceStationName) {
        this.sourceStationName = sourceStationName;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
}
