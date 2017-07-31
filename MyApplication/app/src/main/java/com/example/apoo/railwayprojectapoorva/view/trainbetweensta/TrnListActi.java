package com.example.apoo.railwayprojectapoorva.view.trainbetweensta;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.apoo.railwayprojectapoorva.R;
import com.example.apoo.railwayprojectapoorva.adapter.trainbetwnstat.TrainbetweenStationAdapter;
import com.example.apoo.railwayprojectapoorva.entities.trainbtwnstat.SinglerowItemfill;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class TrnListActi extends AppCompatActivity  {

    ListView listTrains;
    ArrayList<SinglerowItemfill> singlerowItemfillsarray = new ArrayList<>();
    TrainbetweenStationAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_list);
        listTrains = (ListView) findViewById(R.id.list_view_train_list_new);
        adapter = new TrainbetweenStationAdapter(this, singlerowItemfillsarray);
        Intent intent = getIntent();
        String sourcestationcodeedittext = intent.getExtras().getString("parameter1");
        String destinationstationcodeedittext = intent.getExtras().getString("paramater2");
        String imagepickertextset = intent.getExtras().getString("parameter3");

        Log.d("URL", "onCreate: "+sourcestationcodeedittext+"hour  -->"+destinationstationcodeedittext+"hour  -->"+imagepickertextset);
        listTrains.setAdapter(adapter);
        String url1="http://api.railwayapi.com/between/source/"+sourcestationcodeedittext+"/dest/"+destinationstationcodeedittext+"/date/"+imagepickertextset+"/apikey/01u8xbb1/";
        LoadItems task = new LoadItems();

        task.execute(url1);
    }

    public class LoadItems extends AsyncTask<String, Void, String> {

        /*
        * overrided method of async task
        * we can start the progress dialog here
        * */

        @Override
        protected void onPreExecute() {

            super.onPreExecute();

        }

        /**
         *
         * download the json data here
         */

        @Override
        protected String doInBackground(String... params) {

            String str = params[0];
            String result = "";

            try {
                URL url = new URL(str);
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.connect();

                    //checking the response code here

                    if (httpURLConnection.getResponseCode() == 200) {

                        BufferedReader bufferedReader = new BufferedReader
                                (new InputStreamReader(httpURLConnection.getInputStream()));

                        while(true)
                        {
                            String line = bufferedReader.readLine();
                            if (line == null){
                                break;
                            } else {
                                result = result+line;
                            }

                        }
                        bufferedReader.close();
                        httpURLConnection.disconnect();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return result;
        }

    /*
    * after the downloading data fetch from array here
     * and set to adapter
    * */

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (s!=null && s.length()>0) {
                try {

                    JSONObject jsonResponse = new JSONObject(s);
                    String total = jsonResponse.getString("total");

                    JSONArray jsonArray = jsonResponse.getJSONArray("train");

                    for(int i = 0; i < jsonArray.length(); i++) {    //for loop 1
                        JSONObject r = jsonArray.getJSONObject(i);
                        String name = r.getString("name");
                        String number = r.getString("number");
                        String trainName = name + "-" + number;
                        String depatureTime = r.getString("src_departure_time");
                        String arrivalTime = r.getString("dest_arrival_time");
                        String travelTime = r.getString("travel_time");
                        JSONObject fromInfo = r.getJSONObject("from");
                        JSONObject toInfo = r.getJSONObject("to");
                        String fromCode = fromInfo.getString("code");
                        String toCode = toInfo.getString("code");
                        JSONArray classarray = r.getJSONArray("classes");
                        Log.d("--got--", "values" + name + "name :" + number + "--number--" + number);

                        JSONArray daysArray2 = r.getJSONArray("classes");

                           Log.d("--", "arrrrrrrrrrr: " + "--" + daysArray2.get(0) + "got  0 array "+ daysArray2.get(1) + "got  1 array "+ daysArray2.get(2) + "got  2 array ");
                           singlerowItemfillsarray.add(new SinglerowItemfill(name, fromCode, toCode, depatureTime, arrivalTime, travelTime,number));

                           adapter.notifyDataSetChanged();
                    }

            } catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

}




