package com.example.apoo.railwayprojectapoorva.model.trainbetweenstation;

import com.example.apoo.railwayprojectapoorva.api.APIClientCallback;
import com.example.apoo.railwayprojectapoorva.api.ApiClient;
import com.example.apoo.railwayprojectapoorva.entities.trainbtwnstat.TrainbetweenStation;

/**
 * Created by Apoo on 5/23/2017.
 */

public class TrainbetweenStationModelImp implements TrainbetweenStationModel {

    private ApiClient apiClient;

    public TrainbetweenStationModelImp(ApiClient apiClient) {
        this.apiClient = apiClient;
    }


    @Override
    public void getTrainsBetweenStations(APIClientCallback<TrainbetweenStation> apiClientCallback, String sourcestationCode, String destinationstationCode, String dateforenquiry, String APIKEY) {

        apiClient.getTrainsBetweenStations(apiClientCallback,sourcestationCode,destinationstationCode,dateforenquiry,APIKEY);
    }
}
