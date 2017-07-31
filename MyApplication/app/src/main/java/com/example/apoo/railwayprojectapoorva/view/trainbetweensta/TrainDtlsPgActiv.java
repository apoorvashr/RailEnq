package com.example.apoo.railwayprojectapoorva.view.trainbetweensta;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.apoo.railwayprojectapoorva.R;
import com.example.apoo.railwayprojectapoorva.entities.trainbtwnstat.TrainbetweenStation;

import java.util.ArrayList;

public class TrainDtlsPgActiv extends AppCompatActivity implements Trainbtwnstatnviw2 {

    TextView trainNameTv,departureTimeTv,arrivalTimeTv;
    TextView traveltTimeTv;
    TextView trainNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_details_page);

        String  fromstation = getIntent().getExtras().getString("fromstation");
        String  tostation = getIntent().getExtras().getString("tostation");
        String  departuretime = getIntent().getExtras().getString("departuretime");
        String  arrivaltime = getIntent().getExtras().getString("arrivaltime");
        String  traveltime = getIntent().getExtras().getString("traveltime");
        String  trainnumber = getIntent().getExtras().getString("trainnumber");
        String  trainnname = getIntent().getExtras().getString("trainname");

        Log.d("2nd activity get intent", "onCreate: "+ fromstation+"--to station-"+tostation+ "-departuretime--"
                + departuretime+ "-arrival time-"+arrivaltime+"-travel time-"+traveltime+"trainnumber--"+trainnumber+"trainname"+
        trainnname);

        trainNameTv = (TextView) findViewById(R.id.textview_train_name_detail_page);
        departureTimeTv =(TextView) findViewById(R.id.departure_time_detail_page);
        arrivalTimeTv = (TextView) findViewById(R.id.arrival_time_detail_page);
        traveltTimeTv = (TextView) findViewById(R.id.total_travel_time_details_page);
        trainNumber = (TextView) findViewById(R.id.textview_train_number_detail_page);

        trainNameTv.setText(trainnname);
        departureTimeTv.setText(departuretime);
        arrivalTimeTv.setText(arrivaltime);
        traveltTimeTv.setText(traveltime);
        trainNumber.setText(trainnumber);

    }


    @Override
    public void showlistoftrainsbetweenstaions(TrainbetweenStation stationAutoCompleteSuggest) {

        Log.d("activity", "showlist here--: "+stationAutoCompleteSuggest);

            int total = stationAutoCompleteSuggest.getTotal();
            ArrayList<Integer> totalval = new ArrayList<>();

            for(int k=0;k<=total-1;k++) {
                totalval.add(k);
                Log.d("----", "total_value_list_size: "+totalval);
            }

            for (int g=0;g<=totalval.size()-1; g++)
            {
                for (int o=0; o<=8-1;o++)
                {
                    Log.d("", "showlistoftrainsbetweenstaions: "+stationAutoCompleteSuggest.getTrain().get(g).getClasses());

                    Log.d("", "classcode: "+stationAutoCompleteSuggest.getTrain().get(g).getClasses().get(g).getClassCode());
                    Log.d("", "availability: "+stationAutoCompleteSuggest.getTrain().get(g).getClasses().get(g).getAvailable());
                }
            }
    }

    @Override
    public void showerrorfetchinglist(String error) {

    }
}

