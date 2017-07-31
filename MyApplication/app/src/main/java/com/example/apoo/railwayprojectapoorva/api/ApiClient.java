package com.example.apoo.railwayprojectapoorva.api;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.example.apoo.railwayprojectapoorva.MyApplication;
import com.example.apoo.railwayprojectapoorva.R;
import com.example.apoo.railwayprojectapoorva.entities.trainautocompsug.StationAutoCompleteSuggest;
import com.example.apoo.railwayprojectapoorva.entities.trainautocompsug.TrainAutoCompleteSuggest;
import com.example.apoo.railwayprojectapoorva.entities.trainbtwnstat.TrainbetweenStation;
import com.example.apoo.railwayprojectapoorva.entities.trainnmfromnmbr.TainNameNumberResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Apoo on 5/12/2017.
 */

public class ApiClient {
    private Context context;
    private Retrofit retrofit;
    private RailwayServiceApi railwayServiceApi;
    private String TAG = "API_CLIENT";

    //constructor

    public ApiClient(Context context) {
        this.context = context;
        this.retrofit = MyApplication.getRetrofit();
    }

    /*
    * This method hit the request to server,
    * requesting server to give the full name of the train
    * response can be used for the lists to complete the train name part
    * @return - the value input as void
    * @param - the train name or number , api key
    *
    * */

    public void getAutoCompleteSuggestTrainName(final APIClientCallback<TrainAutoCompleteSuggest> apiClientCallback
            , String partialTrainNameOrNumber, String APIKEY) {
        /*if (isConnectedToInternet()) {
            apiClientCallback.onFailure(new NetworkErrorException(context.getString(R.string.error_no_internet)));
        } else {*/

         railwayServiceApi = retrofit.create(RailwayServiceApi.class);
         final Call<TrainAutoCompleteSuggest> detailResponseCall = railwayServiceApi.getStationName(partialTrainNameOrNumber,APIKEY);
            Log.d(TAG, "loginEmployee api client: " + partialTrainNameOrNumber + APIKEY);

            detailResponseCall.enqueue(new Callback<TrainAutoCompleteSuggest>() {
                @Override
                public void onResponse(Call<TrainAutoCompleteSuggest> call, Response<TrainAutoCompleteSuggest> response) {
                    TrainAutoCompleteSuggest trainAutoCompleteSuggest = response.body();
                    apiClientCallback.onSuccess(trainAutoCompleteSuggest);
                    Log.d(TAG, "onResponse: "+trainAutoCompleteSuggest);

                    if (trainAutoCompleteSuggest.getResponseCode().equals("403"))
                    {
                        apiClientCallback.onFailure(new QuotaExhaustedException(context.getResources().getString(R.string.quota_exhausted)));
                    }
                }

                @Override
                public void onFailure(Call<TrainAutoCompleteSuggest> call, Throwable t) {
                    apiClientCallback.onFailure(new NetworkException(context.getString(R.string.error_no_internet)));

                }
            });

       /* }*/
    }

    /*
    * This method hit the request to server,
    * requesting the server to replay the station  name
    * response can be used for the lists to complete the autocomplete station name part
    * @return - the value input as void
    * @param - the train name or number , api key
    *
    * */

    public void getAutoCompleteSuggestStationName(final APIClientCallback<StationAutoCompleteSuggest> apiClientCallback
            , String partialStationName, String APIKEY) {
/*
        if (isConnectedToInternet()) {
            apiClientCallback.onFailure(new NetworkException(context.getString(R.string.error_no_internet)));
        } else {*/
            railwayServiceApi = retrofit.create(RailwayServiceApi.class);
            final Call<StationAutoCompleteSuggest> detailStationNameResponseCall = railwayServiceApi.getStationsNames(partialStationName,APIKEY);
            Log.d(TAG, "loginEmployee api client: " + partialStationName + APIKEY);

            detailStationNameResponseCall.enqueue(new Callback<StationAutoCompleteSuggest>() {
                @Override
                public void onResponse(Call<StationAutoCompleteSuggest> call, Response<StationAutoCompleteSuggest> response) {
                    StationAutoCompleteSuggest stationAutoCompleteSuggest = response.body();
                    apiClientCallback.onSuccess(stationAutoCompleteSuggest);
                    Log.d(TAG, "onResponse: "+stationAutoCompleteSuggest);

                    if (stationAutoCompleteSuggest.getResponseCode().equals(403))
                    {
                        apiClientCallback.onFailure(new QuotaExhaustedException(context.getResources().getString(R.string.quota_exhausted)));
                    }
                }

                @Override
                public void onFailure(Call<StationAutoCompleteSuggest> call, Throwable t) {
                    apiClientCallback.onFailure(new NetworkException(context.getString(R.string.error_no_internet)));
                }
            });

        }
/*    }*/

    /*
    * This method hit the request to server,
    * requesting the server to replay the station  name
    * response can be used for getting the trains between to stations
    * @return - the value input as void
    * @param - the train name or number , api key
    *
    * */

    public void getTrainsBetweenStations(final APIClientCallback<TrainbetweenStation> apiClientCallback
            , String sourcestationcode,String destinationstationcode,String dateinddmmformat, String APIKEY) {

        if (isConnectedToInternet()) {
            apiClientCallback.onFailure(new NetworkException(context.getString(R.string.error_no_internet)));
        } else {
            railwayServiceApi = retrofit.create(RailwayServiceApi.class);
            final Call<TrainbetweenStation> detailStationNameResponseCall = railwayServiceApi.gettrainbetweenstations(sourcestationcode,destinationstationcode,dateinddmmformat,APIKEY);
            Log.d(TAG, "trainbetweenstationmodel_before_server_hit" + sourcestationcode+destinationstationcode+dateinddmmformat + APIKEY);

            detailStationNameResponseCall.enqueue(new Callback<TrainbetweenStation>() {
                @Override
                public void onResponse(Call<TrainbetweenStation> call, Response<TrainbetweenStation> response) {
                    TrainbetweenStation trainbetweenStation = response.body();
                    apiClientCallback.onSuccess(trainbetweenStation);
                    Log.d(TAG, "onResponse: trainbet_station_pojo "+trainbetweenStation);

                    /*if (trainbetweenStation.getResponseCode().equals(403))
                    {
                        apiClientCallback.onFailure(new QuotaExhaustedException(context.getResources().getString(R.string.quota_exhausted)));
                    }*/
                }

                @Override
                public void onFailure(Call<TrainbetweenStation> call, Throwable t) {
                    apiClientCallback.onFailure(new NetworkException(context.getString(R.string.error_no_internet)));
                }
            });

        }
    }


     /*
    * This method hit the request to server,
    * requesting the server to replay the station  name
    * response can be used for getting the trains from trainnumbers
    * @return - the value input as void
    * @param - the train name or number , api key
    *
    * */

    public void getTrainnameFromNumber(final APIClientCallback<TainNameNumberResponse> apiClientCallback, final String trainnameornumber, String APIKEY) {

       /* if (isConnectedToInternet()) {
            apiClientCallback.onFailure(new NetworkException(context.getString(R.string.error_no_internet)));
        }*/

       /* else{*/
            railwayServiceApi = retrofit.create(RailwayServiceApi.class);
            final Call<TainNameNumberResponse> tainNameNumberResponseCall = railwayServiceApi.getTrainnameFromNumber(trainnameornumber,APIKEY);

            tainNameNumberResponseCall.enqueue(new Callback<TainNameNumberResponse>() {
                @Override
                public void onResponse(Call<TainNameNumberResponse> call, Response<TainNameNumberResponse> response) {

                    TainNameNumberResponse tainNameNumberResponse = response.body();
                    apiClientCallback.onSuccess(tainNameNumberResponse);
                    Log.d(TAG, "onResponse: "+tainNameNumberResponse);
                }

                @Override
                public void onFailure(Call<TainNameNumberResponse> call, Throwable t) {
                    apiClientCallback.onFailure(new NetworkException(context.getString(R.string.error_no_internet)));
                    Log.d(TAG, "failure: "+t.getMessage());
                }
            });
        }
    /*}*/

//------------------------------------commented---------volley used---------------------------------------------------

   /* public void getTrainFare(final APIClientCallback<TainFareResponse> apiClientCallback, final String trainnumber, String sourceststioncode, String destinationststioncode,
                             String ageofpassenger,String dateddmmyyyy,String quotacode,String APIKEY) {

       *//* if (isConnectedToInternet()) {
            apiClientCallback.onFailure(new NetworkException(context.getString(R.string.error_no_internet)));
        }
        else {*//*

           railwayServiceApi = retrofit.create(RailwayServiceApi.class);

            final Call<TainFareResponse> tainFareResponseCall = railwayServiceApi.getTrainFare(trainnumber,sourceststioncode,destinationststioncode,ageofpassenger,
                    dateddmmyyyy,quotacode,APIKEY);

            tainFareResponseCall.enqueue(new Callback<TainFareResponse>() {
                @Override
                public void onResponse(Call<TainFareResponse> call, Response<TainFareResponse> response) {
                  TainFareResponse tainFareResponse = response.body();
                    apiClientCallback.onSuccess(tainFareResponse);
                }

                @Override
                public void onFailure(Call<TainFareResponse> call, Throwable t) {
                    apiClientCallback.onFailure(new NetworkErrorException(context.getString(R.string.error_no_internet)));
                }
            });
        }*/
 /*   }*/


//------------------------------------commented---------volley used---------------------------------------------------------


    /*
     * This method to check the internet connectivity
     * @return - the value input is boolean
     * @param - null , no parameters
     *
     * */

    private boolean isConnectedToInternet() {
        try {
            if (context != null)
            {
                ConnectivityManager connectivityManager = (ConnectivityManager)
                        context.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                return  networkInfo != null && networkInfo.isConnected();

            } return false;
        } catch (Exception e) {
            return false;
        }
    }
}


