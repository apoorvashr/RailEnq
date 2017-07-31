package com.example.apoo.railwayprojectapoorva.view.trainarrivalsatsta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.TextView;

import com.example.apoo.railwayprojectapoorva.R;


public class TrainarrivalatstationDetailActivity extends AppCompatActivity {

    TextView textViewtrainname,textViewtrainnumber;
    TextView textViewDelaydeparture,textViewDelayArrival;
    TextView textViewActualArrival,textViewScheduledArrival;
    TextView textViewActualDeparture,textViewScheduledDeparture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainarrivalatstation_detail);
        textViewtrainname = (TextView) findViewById(R.id.train_name_train_name_availability_detail_mod);
        textViewtrainnumber = (TextView) findViewById(R.id.textview_number_availability_detail_mod);
        textViewDelaydeparture = (TextView) findViewById(R.id.delay_departure_tv);
        textViewDelayArrival = (TextView) findViewById(R.id.delay_arrival_tv);
        textViewActualArrival = (TextView) findViewById(R.id.actual_arrival_tv);
        textViewActualDeparture = (TextView) findViewById(R.id.actual_departure_tv);
        textViewScheduledDeparture = (TextView) findViewById(R.id.schedule_departure_tv);
        textViewScheduledArrival =(TextView) findViewById(R.id.schedule_arrival_tv);

        Intent intent = getIntent();
        String textViewgetTrainNumber = intent.getExtras().getString("parameter1");
        String textviewgetTrainName = intent.getExtras().getString("parameter2");
        String textViewgetDelaydepature = intent.getExtras().getString("parameter3");
        String textviewgetDelayarrive = intent.getExtras().getString("parameter4");
        String editTextgetgetActualarrive = intent.getExtras().getString("parameter5");
        String textviewgetgetActualdepature = intent.getExtras().getString("parameter6");
        String editTextgetgetgetSch_depature= intent.getExtras().getString("parameter7");
        String textviewgetgetgetScharrive = intent.getExtras().getString("parameter8");

        Log.d("URL", "onCreate: "+textViewgetTrainNumber+"--name--"+textviewgetTrainName+"--delay departure"+textViewgetDelaydepature+"--delay arrive"+textviewgetDelayarrive+
                "--actual arrival"+editTextgetgetActualarrive+"--Actualdepature--"+textviewgetgetActualdepature+"--schedule departure"+editTextgetgetgetSch_depature+"--schedule arrival"
        +textviewgetgetgetScharrive);

        textViewtrainnumber.setText(textViewgetTrainNumber);
        textViewtrainname.setText(textviewgetTrainName);
        textViewDelaydeparture.setText(textViewgetDelaydepature);
        textViewDelayArrival.setText(textviewgetDelayarrive);
        textViewActualArrival.setText(editTextgetgetActualarrive);
        textViewActualDeparture.setText(textviewgetgetActualdepature);
        textViewScheduledDeparture.setText(editTextgetgetgetSch_depature);
        textViewScheduledArrival.setText(textviewgetgetgetScharrive);
    }
}
