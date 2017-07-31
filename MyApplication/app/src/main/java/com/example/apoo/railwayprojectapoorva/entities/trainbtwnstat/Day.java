package com.example.apoo.railwayprojectapoorva.entities.trainbtwnstat;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Day {

  @SerializedName("day-code")
  @Expose
  private String dayCode;
  @SerializedName("runs")
  @Expose
  private String runs;

  public String getDayCode() {
    return dayCode;
  }

  public void setDayCode(String dayCode) {
    this.dayCode = dayCode;
  }

  public String getRuns() {
    return runs;
  }

  public void setRuns(String runs) {
    this.runs = runs;
  }

}