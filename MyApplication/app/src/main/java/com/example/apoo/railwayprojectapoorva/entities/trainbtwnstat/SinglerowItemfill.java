package com.example.apoo.railwayprojectapoorva.entities.trainbtwnstat;

import java.io.Serializable;

/**
 * Created by Apoo on 5/26/2017.
 */

public class SinglerowItemfill implements Serializable {

        String trainName;
        String fromCode;
        String toCode;
        String depatureTime;
        String arrivalTime;
        String travelTime;
        String trainNumber;


        public SinglerowItemfill(String trainName, String fromCode, String toCode, String depatureTime, String arrivalTime, String travelTime,String trainNumber) {
            this.trainName = trainName;
            this.fromCode = fromCode;
            this.toCode = toCode;
            this.depatureTime = depatureTime;
            this.arrivalTime = arrivalTime;
            this.travelTime = travelTime;
            this.trainNumber = trainNumber;
        }

        public String getTrainName() {
            return trainName;
        }

        public void setTrainName(String trainName) {
            this.trainName = trainName;
        }

        public String getFromCode() {
            return fromCode;
        }

        public void setFromCode(String fromCode) {
            this.fromCode = fromCode;
        }

        public String getToCode() {
            return toCode;
        }

        public void setToCode(String toCode) {
            this.toCode = toCode;
        }

        public String getArrivalTime() {
            return arrivalTime;
        }

        public void setArrivalTime(String arrivalTime) {
            this.arrivalTime = arrivalTime;
        }

        public String getDepatureTime() {
            return depatureTime;
        }

        public void setDepatureTime(String depatureTime) {
            this.depatureTime = depatureTime;
        }

        public String getTravelTime() {
            return travelTime;
        }

        public void setTravelTime(String travelTime) {
            this.travelTime = travelTime;
        }

        public String getTrainNumber() { return trainNumber;}

        public void setTrainNumber(String trainNumber) {this.trainNumber = trainNumber;}

    }

