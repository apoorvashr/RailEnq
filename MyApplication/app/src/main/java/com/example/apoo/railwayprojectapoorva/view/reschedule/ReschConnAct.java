package com.example.apoo.railwayprojectapoorva.view.reschedule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.apoo.railwayprojectapoorva.R;
import com.example.apoo.railwayprojectapoorva.adapter.cancelled.TrainCancelAdapter;
import com.example.apoo.railwayprojectapoorva.adapter.reschedule.RescheduleAdapter;
import com.example.apoo.railwayprojectapoorva.entities.cancel.Cancel;
import com.example.apoo.railwayprojectapoorva.entities.reschedule.Reschedule;
import com.example.apoo.railwayprojectapoorva.view.canceltrain.CancelTConnActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ReschConnAct extends AppCompatActivity {

    RequestQueue requestQueue;
    ArrayList<Reschedule> listUSERS = new ArrayList<>();
    RecyclerView recyclerViewTrainReschedule;
    RescheduleAdapter adapter;
    String stationDestinationName;
    String stationDestinationstationcode;
    String stationfrom_stationcode;
    String stationfrom_station;
    String trainname;
    String stationto_stationcode;
    String stationto_station;
    String stationsourcename,stationSourceCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resch_conn);

        recyclerViewTrainReschedule = (RecyclerView) findViewById(R.id.recycler_view_train_reschedule_detail);

        Intent intent = getIntent();
        String datevalueforenquiry = intent.getExtras().getString("paramater1");
        //http://api.railwayapi.com/v2/rescheduled/date/18-07-2017/apikey/01u8xbb1/
         String URL = "http://api.railwayapi.com/v2/rescheduled/date/"+datevalueforenquiry+"/apikey/01u8xbb1/";
        Log.d("URL", "onCreate: "+datevalueforenquiry+"sourcestation -->");

        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024);
        Network network = new BasicNetwork(new HurlStack());
        requestQueue = new RequestQueue(cache, network);
        requestQueue.start();


        //TODO: requesting to server from volley here
        final RequestQueue requestQueue = Volley.newRequestQueue(ReschConnAct.this);
        final JsonObjectRequest jsonobjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        VolleyLog.d("RESPONSE_ACTIVITY_VOLLY", "onResponse: "+response.toString());
                        Log.d("response volley 222222", "onResponse: "+response);

                        try {
                            JSONArray objtrainnamae = response.getJSONArray("trains");
                            for (int i = 0; i < objtrainnamae.length(); i++) {
                                JSONObject trainsStartJsonObject = objtrainnamae.getJSONObject(i);

                                JSONObject destObj = trainsStartJsonObject.getJSONObject("to");
                                for (int j = 0; j < destObj.length(); j++) {
                                    stationDestinationName = destObj.getString("name");
                                    stationDestinationstationcode = destObj.getString("code");
                                }

                                JSONObject destinationObj = trainsStartJsonObject.getJSONObject("from_station");
                                for (int k = 0; k < destinationObj.length(); k++) {
                                    stationfrom_station = destinationObj.getString("name");
                                    stationfrom_stationcode = destinationObj.getString("code");
                                    Log.d("", "onResponse: "+stationfrom_station+"----got---"+stationfrom_stationcode);
                                }

                                JSONObject to_stationObj = trainsStartJsonObject.getJSONObject("to_station");
                                for (int j = 0; j < to_stationObj.length(); j++) {
                                    stationto_station = to_stationObj.getString("name");
                                    stationto_stationcode = to_stationObj.getString("code");
                                }

                                String trainnumberr = trainsStartJsonObject.getString("number");
                                String time_diff = trainsStartJsonObject.getString("time_diff");
                                String rescheduled_time = trainsStartJsonObject.getString("rescheduled_time");
                                String rescheduled_date = trainsStartJsonObject.getString("rescheduled_date");
                                 trainname = trainsStartJsonObject.getString("name");

                                JSONObject from = trainsStartJsonObject.getJSONObject("from");
                                for (int j = 0; j < from.length(); j++) {
                                    stationsourcename = from.getString("name");
                                    stationSourceCode = from.getString("code");
                                }
                                Log.d("", "onResponse: recyclerview"+stationDestinationName+" destination sttion name "+stationfrom_stationcode+" station from station code "+trainname+ "  train name "+stationto_station+ "to station "+time_diff
                                      +"time difference "  +trainnumberr+" train number "+rescheduled_time+" rescheduled time "+rescheduled_date+" rescheduled date "+stationfrom_station+ " stationfrom_station name");

                                listUSERS.add(new Reschedule(stationDestinationName,stationfrom_stationcode,trainname,stationto_station,time_diff
                                        ,trainnumberr,rescheduled_time,rescheduled_date,stationfrom_station));
                            }
                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }

                        adapter = new RescheduleAdapter(getBaseContext(),listUSERS);
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseContext());
                        recyclerViewTrainReschedule.setLayoutManager(linearLayoutManager);
                        recyclerViewTrainReschedule.setAdapter(adapter);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                VolleyLog.d("RESPONSE_ACTIVITY_VOLLY", "Error: " + error.getMessage());
            }
        });

        requestQueue.add(jsonobjectRequest);
    }

    }

