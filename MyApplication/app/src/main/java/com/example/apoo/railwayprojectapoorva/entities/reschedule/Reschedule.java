package com.example.apoo.railwayprojectapoorva.entities.reschedule;

/**
 * Created by Apoo on 7/22/2017.
 */

public class Reschedule {

    String toStationName;
    String from_StationName;
    String trainName;
    String to_station;
    String time_diff;
    String trainNumber;
    String rescheduled_time;
    String rescheduled_date;
    String fromStationName;


    public Reschedule(String toStationName, String from_StationName, String trainName, String to_station, String time_diff, String trainNumber, String rescheduled_time, String rescheduled_date, String fromStationName) {
        this.toStationName = toStationName;
        this.from_StationName = from_StationName;
        this.trainName = trainName;
        this.to_station = to_station;
        this.time_diff = time_diff;
        this.trainNumber = trainNumber;
        this.rescheduled_time = rescheduled_time;
        this.rescheduled_date = rescheduled_date;
        this.fromStationName = fromStationName;
    }

    public String getToStationName() {
        return toStationName;
    }

    public void setToStationName(String toStationName) {
        this.toStationName = toStationName;
    }

    public String getFrom_StationName() {
        return from_StationName;
    }

    public void setFrom_StationName(String from_StationName) {
        this.from_StationName = from_StationName;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getTo_station() {
        return to_station;
    }

    public void setTo_station(String to_station) {
        this.to_station = to_station;
    }

    public String getTime_diff() {
        return time_diff;
    }

    public void setTime_diff(String time_diff) {
        this.time_diff = time_diff;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getRescheduled_time() {
        return rescheduled_time;
    }

    public void setRescheduled_time(String rescheduled_time) {
        this.rescheduled_time = rescheduled_time;
    }

    public String getRescheduled_date() {
        return rescheduled_date;
    }

    public void setRescheduled_date(String rescheduled_date) {
        this.rescheduled_date = rescheduled_date;
    }

    public String getFromStationName() {
        return fromStationName;
    }

    public void setFromStationName(String fromStationName) {
        this.fromStationName = fromStationName;
    }

}
