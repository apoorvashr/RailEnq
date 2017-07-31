package com.example.apoo.railwayprojectapoorva.presenter.trainnmfrmnmbr;

import com.example.apoo.railwayprojectapoorva.api.APIClientCallback;
import com.example.apoo.railwayprojectapoorva.api.ApiClient;
import com.example.apoo.railwayprojectapoorva.entities.trainnmfromnmbr.TainNameNumberResponse;
import com.example.apoo.railwayprojectapoorva.model.trainnamefromnumber.TrainnameFromNumberModelImp;
import com.example.apoo.railwayprojectapoorva.model.trainnamefromnumber.TrainnameFromnumberModel;
import com.example.apoo.railwayprojectapoorva.view.trainnmnumbr.Gettrainnameornmbrview;


/**
 * Created by Apoo on 6/8/2017.
 */

public class TrainnamefrmnumPreImp implements TrainnamefrmnumberPre {

    Gettrainnameornmbrview view;
    TrainnameFromnumberModel model;
    APIClientCallback<TainNameNumberResponse> apiClientCallback;
    ApiClient apiClient;

    public TrainnamefrmnumPreImp(Gettrainnameornmbrview view, ApiClient apiclient) {
        this.view = view;
        this.apiClient = apiclient;
        this.model = new TrainnameFromNumberModelImp(apiclient);
        createCallback();
    }

    //TODO: method to get the response
    private void createCallback() {
       apiClientCallback = new APIClientCallback<TainNameNumberResponse>() {
           @Override
           public void onSuccess(TainNameNumberResponse success) {
               view.onSuccess(success);

           }

           @Override
           public void onFailure(Exception e) {

               view.onFailure(e.getMessage());
           }
       } ;
    }


    //TODO: request method for the getting the traindetails based on trainname/number
    @Override
    public void getTrainsBetweenStations(String trainnameornumber, String APIKEY) {

        model.getTrainNameFromNumber(apiClientCallback,trainnameornumber,APIKEY);
    }
}
