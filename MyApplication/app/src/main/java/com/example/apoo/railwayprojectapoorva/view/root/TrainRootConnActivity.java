package com.example.apoo.railwayprojectapoorva.view.root;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
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
import com.example.apoo.railwayprojectapoorva.adapter.trainroot.TrainRootAdapter;
import com.example.apoo.railwayprojectapoorva.entities.root.Root;
import com.example.apoo.railwayprojectapoorva.entities.root.RootClasses;
import com.example.apoo.railwayprojectapoorva.entities.trainnmfromnmbr.TainNameNumberResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TrainRootConnActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RequestQueue requestQueue;
    ArrayList<Root> listUSERS = new ArrayList<>();
    ArrayList<RootClasses> listUSERS2 = new ArrayList<>();
    TrainRootAdapter adapter;
    TextView trainnumber,trainname;
    String classcode,availibility;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_root_conn);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_train_root_detail);
        trainname = (TextView)findViewById(R.id.trainnameetv);
        trainnumber = (TextView)findViewById(R.id.trainnumbertv);

        Intent intent = getIntent();
        String editTextTrainnumber = intent.getExtras().getString("paramater1");
        String URL = "http://api.railwayapi.com/v2/route/train/"+editTextTrainnumber+"/apikey/01u8xbb1/";
        Log.d("URL", "onCreate: "+editTextTrainnumber+"sourcestation -->");
        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024);
        Network network = new BasicNetwork(new HurlStack());
        requestQueue = new RequestQueue(cache, network);
        requestQueue.start();


        //TODO: requesting to server from volley here
        final RequestQueue requestQueue = Volley.newRequestQueue(TrainRootConnActivity.this);
        final JsonObjectRequest jsonobjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        VolleyLog.d("RESPONSE_ACTIVITY_VOLLY", "onResponse: "+response.toString());
                        Log.d("response volley 222222", "onResponse: "+response);

                        try {
                            JSONObject objtrainnamae = response.getJSONObject("train");
                            for (int i = 0; i < objtrainnamae.length(); i++) {
                                String trainnaame = objtrainnamae.getString("name");
                                String trainnumberr = objtrainnamae.getString("number");

                                Log.d("", "onResponse: "+trainnaame+"----got---"+trainnumberr);

                                trainname.setText(trainnaame);
                                trainnumber.setText(trainnumberr);

                                JSONArray classesarray = objtrainnamae.getJSONArray("classes");
                                for (int j = 0; j < classesarray.length(); j++) {
                                    JSONObject classlistopeningobj = classesarray.getJSONObject(j);

                                     classcode = classlistopeningobj.getString("code");
                                     availibility = classlistopeningobj.getString("available");

                                    listUSERS2.add(new RootClasses(classcode, availibility));

                                }
                            }

                            JSONArray rootlist = response.getJSONArray("route");
                            for (int i = 0; i < rootlist.length(); i++) {
                                JSONObject farelistopeningobj = rootlist.getJSONObject(i);
                                String schdep = farelistopeningobj.getString("schdep");
                                String distance = farelistopeningobj.getString("distance");
                                String rootno = farelistopeningobj.getString("no");
                                String fullnamestation = farelistopeningobj.getString("fullname");
                                String day = farelistopeningobj.getString("day");
                                String stationcode = farelistopeningobj.getString("code");
                                String scharr = farelistopeningobj.getString("scharr");
                                String halt = farelistopeningobj.getString("halt");

                                Log.d("", "onResponse: "+schdep+"----got---"+distance+"----"+rootno+fullnamestation);
                                listUSERS.add(new Root(schdep, distance,fullnamestation,day,stationcode,scharr,halt,rootno));

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        adapter = new TrainRootAdapter(getBaseContext(),listUSERS/*,listUSERS2*/);
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
