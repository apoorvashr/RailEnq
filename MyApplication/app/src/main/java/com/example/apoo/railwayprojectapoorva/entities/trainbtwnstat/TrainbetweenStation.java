package com.example.apoo.railwayprojectapoorva.entities.trainbtwnstat;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Apoo on 5/23/2017.
 */

public class TrainbetweenStation {

    @SerializedName("response_code")
    @Expose
    private Integer responseCode;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("train")
    @Expose
    private List<Train> train = null;

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

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Train> getTrain() {
        return train;
    }

    public void setTrain(List<Train> train) {
        this.train = train;
    }

}