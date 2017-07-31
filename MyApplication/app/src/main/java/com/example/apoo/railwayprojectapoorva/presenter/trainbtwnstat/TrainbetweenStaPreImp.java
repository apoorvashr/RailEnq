package com.example.apoo.railwayprojectapoorva.presenter.trainbtwnstat;

import com.example.apoo.railwayprojectapoorva.api.APIClientCallback;
import com.example.apoo.railwayprojectapoorva.api.ApiClient;
import com.example.apoo.railwayprojectapoorva.entities.trainbtwnstat.Train;
import com.example.apoo.railwayprojectapoorva.entities.trainbtwnstat.TrainbetweenStation;
import com.example.apoo.railwayprojectapoorva.model.trainbetweenstation.TrainbetweenStationModel;
import com.example.apoo.railwayprojectapoorva.model.trainbetweenstation.TrainbetweenStationModelImp;
import com.example.apoo.railwayprojectapoorva.view.trainbetweensta.Trainbtwnstatnviw2;

import java.util.List;

/**
 * Created by Apoo on 5/23/2017.
 */

public class TrainbetweenStaPreImp implements TrainbetweenPr {

    private APIClientCallback<TrainbetweenStation> apiClientCallback;
   // TrainbetweenStationView view;
    TrainbetweenStationModel model;
    Trainbtwnstatnviw2 view2;


   /* public TrainbetweenStationsPresenterImp(TrainbetweenStationView view, ApiClient apiClient) {
        createCallBack();
        this.view = view;
        this.model = new TrainbetweenStationModelImp(apiClient);
    }
*/

    public TrainbetweenStaPreImp(Trainbtwnstatnviw2 view2, ApiClient apiClient) {
        createCallBack();
        this.view2 = view2;
        this.model = new TrainbetweenStationModelImp(apiClient);
    }

    /*
    * @method createCallBack - to get the response of the stationName
     * @params - no parameters
     * @return - void
    * */

    private void createCallBack() {
        apiClientCallback = new APIClientCallback<TrainbetweenStation>() {
            @Override
            public void onSuccess(TrainbetweenStation success) {
                List<Train> list = success.getTrain();
//                view.showlistoftrainsbetweenstaions(success);
                view2.showlistoftrainsbetweenstaions(success);
            }

            @Override
            public void onFailure(Exception e) {
               // view.showerrorfetchinglist(e.getMessage());
                view2.showerrorfetchinglist(e.getMessage());
            }
        };
    }


    /*
    * @method createCallBack - to get the response as the list of trains
     * @params - sourcestationcode,destinatiostationcode,dateforenquiry,callback,apikey
     * @return - void
    * */

    @Override
    public void getTrainsBetweenStations(String sourcestationCode, String destinationstationCode, String dateforenquiry, String APIKEY) {
        model.getTrainsBetweenStations(apiClientCallback,sourcestationCode,destinationstationCode,dateforenquiry,APIKEY);
    }
}
