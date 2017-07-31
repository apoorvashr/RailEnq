package com.example.apoo.railwayprojectapoorva.view.trainarrivalsatsta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
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
import com.example.apoo.railwayprojectapoorva.adapter.trainarrivaladap.SampleAdapter;
import com.example.apoo.railwayprojectapoorva.entities.trainarrivalatstation.TrainArrival;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class TrainarrivalatStationConnectionActivity extends AppCompatActivity {

    RequestQueue requestQueue;
    RecyclerView recyclerViewTrainArrivalList;
    TextView textViewstationCode;
    TextView textViewTotalTrains;
    ArrayList<TrainArrival> listUSERS = new ArrayList<>();
    SampleAdapter adapter;
    LinearLayout linearLayoutcontainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_arr_con);

        recyclerViewTrainArrivalList = (RecyclerView) findViewById(R.id.recycler_view_train_arrival_list);
        textViewstationCode = (TextView) findViewById(R.id.station_code_train_arrival);
        textViewTotalTrains = (TextView) findViewById(R.id.total_trains_train_arrival);
        Intent intent = getIntent();
        String editTextStationCode = intent.getExtras().getString("parameter1");
        String textviewHourValue = intent.getExtras().getString("parameter2");
        textViewstationCode.setText(editTextStationCode);

        Log.d("URL", "onCreate: "+editTextStationCode+"hour  -->"+textviewHourValue);
        String URL = "http://api.railwayapi.com/arrivals/station/"+editTextStationCode+"/hours/"+textviewHourValue+"/apikey/01u8xbb1/";
       // String URL = "http://api.railwayapi.com/arrivals/station/"+editTextStationCode+"/hours/"+textviewHourValue+"/apikey/01u8xbb1/";
         Log.d("URL", "onCreate: "+editTextStationCode+"hour  -->"+textviewHourValue);
        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024);
        Network network = new BasicNetwork(new HurlStack());
        requestQueue = new RequestQueue(cache, network);
        requestQueue.start();

        //TODO: requesting to server from volley here
        final RequestQueue requestQueue = Volley.newRequestQueue(TrainarrivalatStationConnectionActivity.this);
        JsonObjectRequest jsonobjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        VolleyLog.d("RESPONSE_ACTIVITY_VOLLY", "onResponse: "+response.toString());
                        Log.d("response volley 222222", "onResponse: "+response);

                        try {

                            String station = response.getString("station");
                            String totalTrain = response.getString("total");
                            textViewTotalTrains.setText(totalTrain);

                            JSONArray arraytrain = response.getJSONArray("trains");
                            for (int i = 0; i < arraytrain.length(); i++) {

                                JSONObject trainarrayinnerobj = arraytrain.getJSONObject(i);

                                String delaydeparture = trainarrayinnerobj.getString("delaydep");
                                String scheduledarrival = trainarrayinnerobj.getString("scharr");
                                String scheduledeparture = trainarrayinnerobj.getString("schdep");
                                String actualdeparture = trainarrayinnerobj.getString("actdep");
                                String trainnumberforlist = trainarrayinnerobj.getString("number");
                                String trainameforlist = trainarrayinnerobj.getString("name");
                                String actualarrival = trainarrayinnerobj.getString("actarr");
                                String delayarrival = trainarrayinnerobj.getString("delayarr");

                                Log.d("", "onResponse: "+scheduledeparture+"----got---"+delayarrival
                                        +"----actual arrival---"+actualarrival+"----actual arrival---"
                                        +actualdeparture +"----trainame---"+trainameforlist+
                                        "----delaydeparture---"+delaydeparture+
                                        "----trainnumber---"+trainnumberforlist);

                               // listUSERS.add(new TrainArrival(scheduledeparture, delayarrival, actualarrival,actualdeparture,trainameforlist,delaydeparture,trainnumberforlist));
                                listUSERS.add(new TrainArrival(delaydeparture,scheduledarrival,scheduledeparture,actualdeparture,trainnumberforlist,trainameforlist,actualarrival,delayarrival));
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        adapter = new SampleAdapter(getBaseContext(),recyclerViewTrainArrivalList,listUSERS);
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseContext());
                        recyclerViewTrainArrivalList.setLayoutManager(linearLayoutManager);
                        recyclerViewTrainArrivalList.setAdapter(adapter);
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
