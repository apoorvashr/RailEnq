package com.example.apoo.railwayprojectapoorva.entities.trainautocompsug;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StationAutoCompleteSuggest {

@SerializedName("response_code")
@Expose
private Integer responseCode;
@SerializedName("total")
@Expose
private Integer total;
@SerializedName("station")
@Expose
private List<Station> station = null;

public Integer getResponseCode() {
return responseCode;
}

public void setResponseCode(Integer responseCode) {
this.responseCode = responseCode;
}

public Integer getTotal() {
return total;
}

public void setTotal(Integer total) {
this.total = total;
}

public List<Station> getStation() {
return station;
}

public void setStation(List<Station> station) {
this.station = station;
}

}