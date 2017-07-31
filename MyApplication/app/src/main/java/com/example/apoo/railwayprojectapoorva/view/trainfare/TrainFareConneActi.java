package com.example.apoo.railwayprojectapoorva.view.trainfare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
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
import com.example.apoo.railwayprojectapoorva.adapter.trainfare.TrainFareQuotaAdapter;
import com.example.apoo.railwayprojectapoorva.entities.trainfare.TrainFare;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TrainFareConneActi extends AppCompatActivity {

    RequestQueue requestQueue;
    TextView textViewTrainNumber;
    TextView textViewtrainname,textViewSourcestation,textViewDestinationstation,textViewQuotaName;
    ArrayList<TrainFare> listUSERS = new ArrayList<>();
    RecyclerView recyclerviewQuota;
    TrainFareQuotaAdapter adapter;
    LinearLayout tableLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_fare_conn_new);

        textViewTrainNumber = (TextView) findViewById(R.id.textview_number_fare_mod);
        textViewtrainname = (TextView) findViewById(R.id.train_name_train_name_fare_mod);
        textViewSourcestation = (TextView) findViewById(R.id.Source_station_fare_mod);
        textViewDestinationstation = (TextView) findViewById(R.id.destination_station_fare_mod);
        textViewQuotaName = (TextView) findViewById(R.id.quota_code_fare_mod);
        recyclerviewQuota = (RecyclerView) findViewById(R.id.recycler_view_train_list_fare_mod);
        tableLayout = (LinearLayout) findViewById(R.id.tablelayout);
        tableLayout.setVisibility(View.GONE);

        Intent intent = getIntent();
        String editTextTrainnumber = intent.getExtras().getString("paramater1");
        String editTextsourcestation = intent.getExtras().getString("paramater2");
        String editTextsestinationstation = intent.getExtras().getString("parameter3");
        String editTextPassengerAge = intent.getExtras().getString("parameter4");
        String selectedQuota = intent.getExtras().getString("parameter5");
        String textViewImgDateSelected = intent.getExtras().getString("parameter6");

        String URL = "http://api.railwayapi.com/fare/train/"+editTextTrainnumber+"/source/"+editTextsourcestation+"/dest/"+editTextsestinationstation+"/age/"+editTextPassengerAge+"/quota/"+selectedQuota+"/doj/"+textViewImgDateSelected+"/apikey/01u8xbb1/";
        Log.d("URL", "onCreate: "+editTextTrainnumber+"sourcestation -->"+editTextsourcestation+"desrination-->"+editTextsestinationstation+"age-->"+editTextPassengerAge+"-->"+selectedQuota+"-->"+textViewImgDateSelected);
        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024);
        Network network = new BasicNetwork(new HurlStack());
        requestQueue = new RequestQueue(cache, network);
        requestQueue.start();



        //TODO: requesting to server from volley here
        final RequestQueue requestQueue = Volley.newRequestQueue(TrainFareConneActi.this);
       JsonObjectRequest jsonobjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        VolleyLog.d("RESPONSE_ACTIVITY_VOLLY", "onResponse: "+response.toString());
                        Log.d("response volley 222222", "onResponse: "+response);

                        if (!response.equals("")) {
                            tableLayout.setVisibility(View.VISIBLE);
                        }
                        try {
                            JSONObject objtrainnamae = response.getJSONObject("train");
                            for (int i = 0; i < objtrainnamae.length(); i++) {
                                String trainnaame = objtrainnamae.getString("name");
                                String trainnumber = objtrainnamae.getString("number");
                                Log.d("", "onResponse: "+trainnaame+"----got---"+trainnumber);

                                textViewtrainname.setText(trainnaame);
                                textViewTrainNumber.setText(trainnumber);
                            }

                            JSONObject objfrom = response.getJSONObject("from");
                            for (int i = 0; i < objfrom.length(); i++) {
                                String fromstation = objfrom.getString("name");
                                String fromstationncode = objfrom.getString("code");
                                Log.d("", "onResponse: "+fromstation+"----got---"+fromstationncode);

                                textViewSourcestation.setText(fromstation);
                            }

                            JSONObject objto = response.getJSONObject("to");
                            for (int i = 0; i < objto.length(); i++) {
                                String tostation = objto.getString("name");
                                String tostationncode = objto.getString("code");
                                Log.d("", "onResponse: "+tostation+"----got---"+tostationncode);

                                textViewDestinationstation.setText(tostation);
                            }


                            JSONObject objquota = response.getJSONObject("quota");
                            for (int i = 0; i < objquota.length(); i++) {
                                String objquotanameString = objquota.getString("name");
                                String objquotacodeString = objquota.getString("code");
                                Log.d("", "onResponse: "+objquotanameString+"----got---"+objquotacodeString);

                                textViewQuotaName.setText(objquotanameString);
                            }

                            JSONArray farelist = response.getJSONArray("fare");
                            for (int i = 0; i < farelist.length(); i++) {
                                JSONObject farelistopeningobj = farelist.getJSONObject(i);
                                String fareinrupee = farelistopeningobj.getString("fare");
                                String farename = farelistopeningobj.getString("name");
                                String farecode = farelistopeningobj.getString("code");

                                Log.d("", "onResponse: "+fareinrupee+"----got---"+farename+"---"+farecode);
                                listUSERS.add(new TrainFare(farecode, farename, fareinrupee));
                            }


                        } catch (JSONException e) {
                            tableLayout.setVisibility(View.GONE);
                            e.printStackTrace();
                        }


                        adapter = new TrainFareQuotaAdapter(listUSERS, getBaseContext());
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseContext());
                        recyclerviewQuota.setLayoutManager(linearLayoutManager);
                        recyclerviewQuota.setAdapter(adapter);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tableLayout.setVisibility(View.GONE);
                VolleyLog.d("RESPONSE_ACTIVITY_VOLLY", "Error: " + error.getMessage());
            }
        });

        requestQueue.add(jsonobjectRequest);
    }
}
