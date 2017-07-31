package com.example.apoo.railwayprojectapoorva.entities.trainarrivalatstation;

public class TrainArrival {
    String trainName;
    String sch_arrive;
    String sch_depature;
    String actual_arrive;
    String actual_depature;
    String delay_arrive;
    String delay_depature;
    String train_number;

    public TrainArrival( String delay_depature,String sch_arrive, String sch_depature,String actual_depature ,String train_number,String trainName, String actual_arrive, String delay_arrive) {
        this.trainName = trainName;
        this.sch_arrive = sch_arrive;
        this.sch_depature = sch_depature;
        this.actual_arrive = actual_arrive;
        this.actual_depature = actual_depature;
        this.delay_arrive = delay_arrive;
        this.delay_depature = delay_depature;
        this.train_number = train_number;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getSch_arrive() {
        return sch_arrive;
    }

    public void setSch_arrive(String sch_arrive) {
        this.sch_arrive = sch_arrive;
    }

    public String getSch_depature() {
        return sch_depature;
    }

    public void setSch_depature(String sch_depature) {
        this.sch_depature = sch_depature;
    }

    public String getActual_arrive() {
        return actual_arrive;
    }

    public void setActual_arrive(String actual_arrive) {
        this.actual_arrive = actual_arrive;
    }

    public String getActual_depature() {
        return actual_depature;
    }

    public void setActual_depature(String actual_depature) {
        this.actual_depature = actual_depature;
    }

    public String getDelay_arrive() {
        return delay_arrive;
    }

    public void setDelay_arrive(String delay_arrive) {
        this.delay_arrive = delay_arrive;
    }

    public String getDelay_depature() {
        return delay_depature;
    }

    public void setDelay_depature(String delay_depature) {
        this.delay_depature = delay_depature;
    }

    public String getTrainNumber() {
        return train_number;
    }

    public void setTrainNumber(String train_number) {
        this.train_number = train_number;
    }

}