package com.example.apoo.railwayprojectapoorva.entities.trainnmfromnmbr;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TainNameNumberResponse implements Serializable{

@SerializedName("train")
@Expose
private Train train;
@SerializedName("response_code")
@Expose
private Integer responseCode;

public Train getTrain() {
return train;
}

public void setTrain(Train train) {
this.train = train;
}

public Integer getResponseCode() {
return responseCode;
}

public void setResponseCode(Integer responseCode) {
this.responseCode = responseCode;
}

}