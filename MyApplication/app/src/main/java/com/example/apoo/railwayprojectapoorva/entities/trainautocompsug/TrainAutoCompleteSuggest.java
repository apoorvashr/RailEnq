    package com.example.apoo.railwayprojectapoorva.entities.trainautocompsug;

    import java.util.List;

    import com.google.gson.annotations.Expose;
    import com.google.gson.annotations.SerializedName;

    public class TrainAutoCompleteSuggest {

            @SerializedName("total")
            @Expose
            private Integer total;
            @SerializedName("train")
            @Expose
            private List<String> train = null;
            @SerializedName("trains")
            @Expose
            private List<Train> trains = null;
            @SerializedName("response_code")
            @Expose
            private Integer responseCode;

            public Integer getTotal() {
                return total;
            }

            public void setTotal(Integer total) {
                this.total = total;
            }

            public List<String> getTrain() {
                return train;
            }

            public void setTrain(List<String> train) {
                this.train = train;
            }

            public List<Train> getTrains() {
                return trains;
            }

            public void setTrains(List<Train> trains) {
                this.trains = trains;
            }

            public Integer getResponseCode() {
    return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
    this.responseCode = responseCode;
    }

    }