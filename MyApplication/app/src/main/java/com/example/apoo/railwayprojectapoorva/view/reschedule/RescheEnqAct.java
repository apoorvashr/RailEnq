package com.example.apoo.railwayprojectapoorva.view.reschedule;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.apoo.railwayprojectapoorva.R;
import com.example.apoo.railwayprojectapoorva.view.canceltrain.CancelTConnActivity;
import com.example.apoo.railwayprojectapoorva.view.canceltrain.CancelTrainEnqAct;
import com.example.apoo.railwayprojectapoorva.view.livetrainstatus.LiveTraiEnqActivity;
import com.example.apoo.railwayprojectapoorva.view.livetrainstatus.LiveTrainConActivity;

public class RescheEnqAct extends AppCompatActivity {

    Button buttonSearchrescheduledTrains;
    String dateofmonth;
    TextView textViewImgDateSelected;
    ImageView imageViewSelectDate;
    public String reversedatevalue;
    LinearLayout container_linear_layout;
    String str = "";
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reschedule);

        buttonSearchrescheduledTrains = (Button) findViewById(R.id.btn_search_rescheduled_train);
        imageViewSelectDate = (ImageView) findViewById(R.id.imageviewselectdate);
        textViewImgDateSelected = (TextView) findViewById(R.id.imageviewDateselectedtextview);
        container_linear_layout = (LinearLayout)findViewById(R.id.container_linear_layout);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Reschedule Train");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        //TODO: imageview to take a date from picker, setting on textview
        imageViewSelectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog dialog = new DatePickerDialog(RescheEnqAct.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                         str = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                        reversedatevalue = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;

                        dateofmonth = year + "" + "0" + (monthOfYear + 1) + "" +dayOfMonth;
                        textViewImgDateSelected.setText(str);
                        Log.d("- reverse date is---", reversedatevalue);
                        String dateResponse2 = reversedatevalue;
                    }
                }, 2017, 06, 17);
                dialog.show();
            }
        });

        //TODO: calling presenter from view requesting for data from server
        buttonSearchrescheduledTrains.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 if (!(str.equals("") || str.equals(null)))  {
                     Intent intent = new Intent (RescheEnqAct.this, ReschConnAct.class);
                     intent.putExtra("paramater1",textViewImgDateSelected.getText().toString());
                     startActivity(intent);
                     textViewImgDateSelected.setText("");
                 } else {
                    Snackbar snackbar = Snackbar.make(container_linear_layout, "please select date", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            }
        });

    }

}
