package com.example.apoo.railwayprojectapoorva.model.trainbetweenstation;

import com.example.apoo.railwayprojectapoorva.api.APIClientCallback;
import com.example.apoo.railwayprojectapoorva.entities.trainbtwnstat.TrainbetweenStation;

/**
 * Created by Apoo on 5/23/2017.
 */

public interface TrainbetweenStationModel {

    public void getTrainsBetweenStations(APIClientCallback<TrainbetweenStation> apiClientCallback, String sourcestationCode, String destinationstationCode, String dateforenquiry, String APIKEY) ;

    }
