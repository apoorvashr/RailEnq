package com.example.apoo.railwayprojectapoorva.model.trainnamefromnumber;

import com.example.apoo.railwayprojectapoorva.api.APIClientCallback;
import com.example.apoo.railwayprojectapoorva.api.ApiClient;
import com.example.apoo.railwayprojectapoorva.entities.trainnmfromnmbr.TainNameNumberResponse;

/**
 * Created by Apoo on 6/8/2017.
 */

public class TrainnameFromNumberModelImp implements TrainnameFromnumberModel {


    ApiClient apiClient;


    public TrainnameFromNumberModelImp(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @Override
    public void getTrainNameFromNumber(APIClientCallback<TainNameNumberResponse> apiClientCallback, String trainnameornumber, String APIKEY) {
        apiClient.getTrainnameFromNumber(apiClientCallback,trainnameornumber,APIKEY);
    }
}
