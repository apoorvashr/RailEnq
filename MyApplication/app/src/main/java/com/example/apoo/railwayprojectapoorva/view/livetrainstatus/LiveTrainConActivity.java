package com.example.apoo.railwayprojectapoorva.view.livetrainstatus;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
import com.example.apoo.railwayprojectapoorva.adapter.livetrain.TrainLiveAdapter;
import com.example.apoo.railwayprojectapoorva.entities.live.Live;
import com.example.apoo.railwayprojectapoorva.entities.live.LiveTrainDetails;
import com.example.apoo.railwayprojectapoorva.util.MySharedPrefrence;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class LiveTrainConActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RequestQueue requestQueue;
    ArrayList<Live> listUSERS = new ArrayList<>();
    ArrayList<LiveTrainDetails> detailsesTrain = new ArrayList<>();
    TrainLiveAdapter adapter;
    FloatingActionButton fabPosition;
    String stationName,code;
    RelativeLayout progres_layout ;
    SwipeRefreshLayout swipeRefreshLayout;
    private boolean isPullToRefreshPulled;
    String editTextTrainnumber;
    String datevalue;
    Context context;
    LinearLayout container_linear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_train_con);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_train_live_detail);
        fabPosition = (FloatingActionButton) findViewById(R.id.fab_button_position);
        container_linear = (LinearLayout) findViewById(R.id.container_linear);
        Intent intent = getIntent();
         editTextTrainnumber = intent.getExtras().getString("paramater1");
         datevalue = intent.getExtras().getString("parameter2");
        progres_layout = (RelativeLayout) findViewById(R.id.progres_layout);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.loan_list_srl);
        connetTOServer();

        if (isConnectedToInternet()) {
            Snackbar snackbar = Snackbar.make(container_linear,getString(R.string.error_no_internet), Snackbar.LENGTH_LONG);
            snackbar.getView().setBackgroundColor(ContextCompat.getColor(context, R.color.red));
            snackbar.show();
        }

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                isPullToRefreshPulled = true;
                connetTOServer();
            }
        });


         fabPosition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               showalertdialog();
             }
        });

    }


    private void connetTOServer() {

        String URL = "http://api.railwayapi.com/v2/live/train/"+editTextTrainnumber+"/date/"+datevalue+"/apikey/01u8xbb1/";
        Log.d("URL", "onCreate: "+editTextTrainnumber+"sourcestation -->"+datevalue);
        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024);
        Network network = new BasicNetwork(new HurlStack());
        requestQueue = new RequestQueue(cache, network);
        requestQueue.start();
        swipeRefreshLayout.setRefreshing(false);
        //TODO: requesting to server from volley here
        final RequestQueue requestQueue = Volley.newRequestQueue(LiveTrainConActivity.this);
        final JsonObjectRequest jsonobjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        VolleyLog.d("RESPONSE_ACTIVITY_VOLLY", "onResponse: "+response.toString());
                        Log.d("response volley 222222", "onResponse: "+response);
                        progres_layout.setVisibility(View.GONE);
                        try {

                            JSONObject objtrainnamae = response.getJSONObject("train");
                            for (int i = 0; i < objtrainnamae.length(); i++) {
                                String  trainnaame = objtrainnamae.getString("name");
                                String  trainnumberr = objtrainnamae.getString("number");
                                String  positionval = response.getString("position");
                                Log.d("", "onResponse: "+trainnaame+"----got---"+trainnumberr+"---got---"+positionval);

                                MySharedPrefrence.setTrainName(getBaseContext(), trainnaame);
                                MySharedPrefrence.setTrainNumber(getBaseContext(), trainnumberr);
                                MySharedPrefrence.setTrainPosition(getBaseContext(), positionval);

                                detailsesTrain.add(new LiveTrainDetails(trainnaame,trainnumberr,positionval));
                            }

                            JSONArray rootlist = response.getJSONArray("route");
                            for (int j = 0; j < rootlist.length(); j++) {
                                JSONObject farelistopeningobj = rootlist.getJSONObject(j);

                                String hasarrived = farelistopeningobj.getString("has_arrived");
                                String actDep = farelistopeningobj.getString("actdep");
                                String actarr = farelistopeningobj.getString("actarr");
                                String stationnumber = farelistopeningobj.getString("no");
                                String schedulearrivaldate = farelistopeningobj.getString("scharr_date");
                                String dayvalue = farelistopeningobj.getString("day");
                                String actualarrivaldate = farelistopeningobj.getString("actarr_date");
                                String statuslatebyminute = farelistopeningobj.getString("status");
                                String distancevalue = farelistopeningobj.getString("distance");
                                String has_departed = farelistopeningobj.getString("has_departed");
                                String scheduledep = farelistopeningobj.getString("schdep");
                                String scheduleArr = farelistopeningobj.getString("scharr");
                                JSONObject stationdown = farelistopeningobj.getJSONObject("station");

                                for (int g = 0; g < stationdown.length(); g++) {
                                    String stationNameDown = stationdown.getString("name");
                                    String codeDown = stationdown.getString("code");
                                    Log.d("", "onRespodowwwnnnnnse: "+stationNameDown+"----got---"+codeDown);
                                }

                                JSONObject station_ = farelistopeningobj.getJSONObject("station_");
                                for (int k = 0; k < station_.length(); k++) {
                                    stationName = station_.getString("name");
                                    code = station_.getString("code");
                                    Log.d("", "onRespodowwwnnnnnidifse: "+stationName+"----got---"+code);
                                }

                                Log.d("", "onResponse: "+scheduledep+"----got---"+has_departed+"----"+statuslatebyminute);
                                listUSERS.add(new Live(stationName,stationnumber,hasarrived,scheduledep,scheduleArr,actDep,actarr,schedulearrivaldate,actualarrivaldate,statuslatebyminute,dayvalue,distancevalue,has_departed));

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        adapter = new TrainLiveAdapter(getBaseContext(),listUSERS);//*,listUSERS2*//*);
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseContext());
                        recyclerView.setLayoutManager(linearLayoutManager);
                        recyclerView.setAdapter(adapter);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                progres_layout.setVisibility(View.GONE);
                VolleyLog.d("RESPONSE_ACTIVITY_VOLLY", "Error: " + error.getMessage());
            }
        });

        requestQueue.add(jsonobjectRequest);

    }


    //TODO: alert dialog method
    private void showalertdialog() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.layout_alertdialog_live_train, null);
        builder.setCancelable(false);
        TextView trainnumber,trainname;
        TextView position;

        trainname = (TextView)view.findViewById(R.id.train_number_text_view_alertDialog);
        trainnumber = (TextView)view.findViewById(R.id.train_name_textview_alertDialog);
        position = (TextView)view.findViewById(R.id.live_train_position_tv);

        trainname.setText(MySharedPrefrence.getTrainName(LiveTrainConActivity.this));
        trainnumber.setText(MySharedPrefrence.getTrainNumber(LiveTrainConActivity.this));
        position.setText(MySharedPrefrence.getTrainposition(LiveTrainConActivity.this));
        builder.setView(view);

        builder.setNegativeButton("close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                builder.setCancelable(true);
            }
        });

        final AlertDialog dialog = builder.create();
        dialog.show();

    }

    //TODO: is connected to internet
    private boolean isConnectedToInternet() {
        try {
            if (context != null) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                return networkInfo != null && networkInfo.isConnected();
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
