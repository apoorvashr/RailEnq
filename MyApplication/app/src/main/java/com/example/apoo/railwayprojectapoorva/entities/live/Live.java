package com.example.apoo.railwayprojectapoorva.entities.live;

/**
 * Created by Apoo on 7/14/2017.
 */

public class Live {

    String stationName;
    String stationNumber;
    String HasArrivedHere;
    String ScheduleDeparture;
    String ScheduleArrival;
    String ActualDeparture;
    String ActualArrival;
    String ScheduleArrivalDate;
    String ActualArrivalDate;
    String StatusLateByMinute;
    String Day;
    String DistanceFromSource;
    String HasDepartedFromHere;

    public Live(String stationName, String stationNumber, String hasArrivedHere, String scheduleDeparture, String scheduleArrival, String actualDeparture, String actualArrival, String scheduleArrivalDate, String actualArrivalDate, String statusLateByMinute, String day, String distanceFromSource, String hasDepartedFromHere) {
        this.stationName = stationName;
        this.stationNumber = stationNumber;
        HasArrivedHere = hasArrivedHere;
        ScheduleDeparture = scheduleDeparture;
        ScheduleArrival = scheduleArrival;
        ActualDeparture = actualDeparture;
        ActualArrival = actualArrival;
        ScheduleArrivalDate = scheduleArrivalDate;
        ActualArrivalDate = actualArrivalDate;
        StatusLateByMinute = statusLateByMinute;
        Day = day;
        DistanceFromSource = distanceFromSource;
        HasDepartedFromHere = hasDepartedFromHere;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationNumber() {
        return stationNumber;
    }

    public void setStationNumber(String stationNumber) {
        this.stationNumber = stationNumber;
    }

    public String getHasArrivedHere() {
        return HasArrivedHere;
    }

    public void setHasArrivedHere(String hasArrivedHere) {
        HasArrivedHere = hasArrivedHere;
    }

    public String getScheduleDeparture() {
        return ScheduleDeparture;
    }

    public void setScheduleDeparture(String scheduleDeparture) {
        ScheduleDeparture = scheduleDeparture;
    }

    public String getScheduleArrival() {
        return ScheduleArrival;
    }

    public void setScheduleArrival(String scheduleArrival) {
        ScheduleArrival = scheduleArrival;
    }

    public String getActualDeparture() {
        return ActualDeparture;
    }

    public void setActualDeparture(String actualDeparture) {
        ActualDeparture = actualDeparture;
    }

    public String getActualArrival() {
        return ActualArrival;
    }

    public void setActualArrival(String actualArrival) {
        ActualArrival = actualArrival;
    }

    public String getScheduleArrivalDate() {
        return ScheduleArrivalDate;
    }

    public void setScheduleArrivalDate(String scheduleArrivalDate) {
        ScheduleArrivalDate = scheduleArrivalDate;
    }

    public String getActualArrivalDate() {
        return ActualArrivalDate;
    }

    public void setActualArrivalDate(String actualArrivalDate) {
        ActualArrivalDate = actualArrivalDate;
    }

    public String getStatusLateByMinute() {
        return StatusLateByMinute;
    }

    public void setStatusLateByMinute(String statusLateByMinute) {
        StatusLateByMinute = statusLateByMinute;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String day) {
        Day = day;
    }

    public String getDistanceFromSource() {
        return DistanceFromSource;
    }

    public void setDistanceFromSource(String distanceFromSource) {
        DistanceFromSource = distanceFromSource;
    }

    public String getHasDepartedFromHere() {
        return HasDepartedFromHere;
    }

    public void setHasDepartedFromHere(String hasDepartedFromHere) {
        HasDepartedFromHere = hasDepartedFromHere;
    }
}
