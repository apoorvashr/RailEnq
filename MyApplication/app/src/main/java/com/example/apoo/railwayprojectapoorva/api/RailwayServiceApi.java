package com.example.apoo.railwayprojectapoorva.api;

import com.example.apoo.railwayprojectapoorva.entities.trainautocompsug.StationAutoCompleteSuggest;
import com.example.apoo.railwayprojectapoorva.entities.trainautocompsug.TrainAutoCompleteSuggest;
import com.example.apoo.railwayprojectapoorva.entities.trainbtwnstat.TrainbetweenStation;
import com.example.apoo.railwayprojectapoorva.entities.trainnmfromnmbr.TainNameNumberResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Apoo on 5/12/2017.
 */

public interface RailwayServiceApi  {


    //TODO: train autocomplete train name, station suggest module Api @param - GET type request

    @GET("suggest_train/trains/{trains}/apikey/{apikey}")
    Call<TrainAutoCompleteSuggest> getStationName (@Path("trains") String partialTrainNameOrNumber,
                                            @Path("apikey") String APIKEY);


    //TODO: train autocomplete station name suggest module Api @param - GET type request
    @GET("suggest_station/name/{name}/apikey/{apikey}")
    Call<StationAutoCompleteSuggest> getStationsNames (@Path("name") String partialStationNumber,
                                                     @Path("apikey") String APIKEY);


    //TODO: train betweenstation  module Api @param - GET type request
    @GET("between/source/{station}/dest/{station2}/date/{date}/apikey/{apikey}")
    Call<TrainbetweenStation> gettrainbetweenstations (@Path("station") String sourcestationcode,
                                                       @Path("station2") String destinationstationcode,
                                                       @Path("date") String date,
                                                       @Path("apikey") String APIKEY);



    //TODO: trainnamefromnumber  module Api @param - GET type request
    @GET("name-number/train/{namenumber}/apikey/{apikey}")

    Call<TainNameNumberResponse> getTrainnameFromNumber (@Path("namenumber") String trainnameornumber,
                                                          @Path("apikey") String APIKEY);


  /*  //TODO: trainnamefromnumber  module Api @param - GET type request
    @GET("fare/train/{trainnumber}/source/{sourcestationcode}/dest/{destinationstationcode}/age/{agepassenger}/quota/{quotacode}/doj/{ddmmyyyy}/apikey/{apikey}")

    Call<TainFareResponse> getTrainFare (@Path("trainnumber") String trainnameornumber,
                                         @Path("sourcestationcode") String sourcestationcode,
                                         @Path("destinationstationcode") String destinationstationcode,
                                         @Path("agepassenger") String agepassenger,
                                         @Path("quotacode") String quotacode,
                                         @Path("ddmmyyyy") String date,
                                         @Path("apikey") String APIKEY);
*/
}
