package com.example.apoo.railwayprojectapoorva.entities.live;

/**
 * Created by Apoo on 7/18/2017.
 */

public class LiveTrainDetails {

    String trainName;
    String trainNumber;
    String trainPosition;

    public LiveTrainDetails(String trainName, String trainNumber, String trainPosition) {

        this.trainName = trainName;
        this.trainNumber = trainNumber;
        this.trainPosition = trainPosition;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getTrainPosition() {
        return trainPosition;
    }

    public void setTrainPosition(String trainPosition) {
        this.trainPosition = trainPosition;
    }
}
