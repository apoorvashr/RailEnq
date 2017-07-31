package com.example.apoo.railwayprojectapoorva.entities.trainbtwnstat;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Train {

  @SerializedName("classes")
  @Expose
  private List<Class> classes = null;
  @SerializedName("travel_time")
  @Expose
  private String travelTime;
  @SerializedName("number")
  @Expose
  private String number;
  @SerializedName("days")
  @Expose
  private List<Day> days = null;
  @SerializedName("to")
  @Expose
  private To to;
  @SerializedName("from")
  @Expose
  private From from;
  @SerializedName("src_departure_time")
  @Expose
  private String srcDepartureTime;
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("no")
  @Expose
  private Integer no;
  @SerializedName("dest_arrival_time")
  @Expose
  private String destArrivalTime;

  public List<Class> getClasses() {
    return classes;
  }

  public void setClasses(List<Class> classes) {
    this.classes = classes;
  }

  public String getTravelTime() {
    return travelTime;
  }

  public void setTravelTime(String travelTime) {
    this.travelTime = travelTime;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public List<Day> getDays() {
    return days;
  }

  public void setDays(List<Day> days) {
    this.days = days;
  }

  public To getTo() {
    return to;
  }

  public void setTo(To to) {
    this.to = to;
  }

  public From getFrom() {
    return from;
  }

  public void setFrom(From from) {
    this.from = from;
  }

  public String getSrcDepartureTime() {
    return srcDepartureTime;
  }

  public void setSrcDepartureTime(String srcDepartureTime) {
    this.srcDepartureTime = srcDepartureTime;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getNo() {
    return no;
  }

  public void setNo(Integer no) {
    this.no = no;
  }

  public String getDestArrivalTime() {
    return destArrivalTime;
  }

  public void setDestArrivalTime(String destArrivalTime) {
    this.destArrivalTime = destArrivalTime;
  }

}