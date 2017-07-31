package com.example.apoo.railwayprojectapoorva.view.canceltrain;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import com.example.apoo.railwayprojectapoorva.adapter.cancelled.TrainCancelAdapter;
import com.example.apoo.railwayprojectapoorva.adapter.trainroot.TrainRootAdapter;
import com.example.apoo.railwayprojectapoorva.entities.cancel.Cancel;
import com.example.apoo.railwayprojectapoorva.entities.root.Root;
import com.example.apoo.railwayprojectapoorva.entities.root.RootClasses;
import com.example.apoo.railwayprojectapoorva.view.root.TrainRootConnActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CancelTConnActivity extends AppCompatActivity {

    RequestQueue requestQueue;
    ArrayList<Cancel> listUSERS = new ArrayList<>();
    RecyclerView recyclerView;
    TrainCancelAdapter adapter;
    String stationsourcename;
    String stationsourcestationcode;
    String stationdestinationcode;
    String stationdestination;
    String trainname;
    String traintype,trainnumber, starttime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel_tconn);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_train_cancel_detail);

        Intent intent = getIntent();
        String datevalueforenquiry = intent.getExtras().getString("paramater1");
        String URL = "http://api.railwayapi.com/v2/cancelled/date/"+datevalueforenquiry+"/apikey/01u8xbb1/";

        Log.d("URL", "onCreate: "+datevalueforenquiry+"sourcestation -->");

        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024);
        Network network = new BasicNetwork(new HurlStack());
        requestQueue = new RequestQueue(cache, network);
        requestQueue.start();


        //TODO: requesting to server from volley here
        final RequestQueue requestQueue = Volley.newRequestQueue(CancelTConnActivity.this);
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

                                JSONObject sourceObj = trainsStartJsonObject.getJSONObject("source");
                                for (int j = 0; j < sourceObj.length(); j++) {
                                     stationsourcename = sourceObj.getString("name");
                                     stationsourcestationcode = sourceObj.getString("code");
                                }

                                JSONObject destinationObj = trainsStartJsonObject.getJSONObject("dest");
                                for (int k = 0; k < destinationObj.length(); k++) {
                                     stationdestination = destinationObj.getString("name");
                                     stationdestinationcode = destinationObj.getString("code");
                                    Log.d("", "onResponse: "+stationdestination+"----got---"+stationdestinationcode);

                                }

                                String trainnumberr = trainsStartJsonObject.getString("number");

                                JSONObject trainObj = trainsStartJsonObject.getJSONObject("train");
                                for (int l = 0; l < trainObj.length(); l++) {
                                     trainname = trainObj.getString("name");
                                     traintype = trainObj.getString("type");
                                     trainnumber = trainObj.getString("number");
                                     starttime = trainObj.getString("start_time");
                                    Log.d("", "onResponse: "+trainname+"----got---"+traintype+"---hhh---"+trainnumber+"-----------"+starttime+"--number"+trainnumberr);

                                }

                                Log.d("", "onResponse: "+traintype+"----got---"+starttime+"---hhh---"+trainnumberr);
                                listUSERS.add(new Cancel(trainname,stationsourcename,stationdestination,trainnumber,traintype,starttime));

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        adapter = new TrainCancelAdapter(getBaseContext(),listUSERS);
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseContext());
                        recyclerView.setLayoutManager(linearLayoutManager);
                        recyclerView.setAdapter(adapter);

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
