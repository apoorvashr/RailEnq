package com.example.apoo.railwayprojectapoorva.view.trainbetweensta;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.apoo.railwayprojectapoorva.R;
import com.example.apoo.railwayprojectapoorva.adapter.autocompadap.AutoCompleteStationAdapter;


public class TrainbtwnEnqAct extends AppCompatActivity  {

    Button showtrains;
    AutoCompleteTextView sourcestationcodeedittext,destinationstationcodeedittext;
    ImageView datepickerbetweenstation;
    TextView imagepickertextset;
    public String reversedatestring;
    String dateofmonth;
    LinearLayout container_linear_layout;
    String str = "";
    String sourcestationcodeString = "";
    String destinationstationcodeString = "";
    AutoCompleteStationAdapter adapter;
    AutoCompleteStationAdapter adapter2;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_between_station_enq);

        sourcestationcodeedittext = (AutoCompleteTextView)findViewById(R.id.sourcestationstaedittexttrainbet);
        destinationstationcodeedittext = (AutoCompleteTextView)findViewById(R.id.destinationstaedittexttrainbet);
        imagepickertextset = (TextView) findViewById(R.id.imageviewDateselectedtextview);
        datepickerbetweenstation = (ImageView) findViewById(R.id.imageviewselectdatetrainbetweenstation);
        container_linear_layout = (LinearLayout)findViewById(R.id.container_linear_layout);
        showtrains = (Button) findViewById(R.id.btn_show_train_trainbetweenstation);
        adapter = new AutoCompleteStationAdapter(this, android.R.layout.simple_dropdown_item_1line);
        adapter2 = new AutoCompleteStationAdapter(this, android.R.layout.simple_dropdown_item_1line);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Train between stations");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //TODO: when autocomplete is clicked
        sourcestationcodeedittext.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String stationName = adapter.getItem(position).getName();
                sourcestationcodeedittext.setText(stationName);
            }
        });

        sourcestationcodeedittext.setAdapter(adapter);


        //TODO: when autocomplete is clicked
        destinationstationcodeedittext.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String stationName = adapter2.getItem(position).getName();
                destinationstationcodeedittext.setText(stationName);
            }
        });

        destinationstationcodeedittext.setAdapter(adapter2);


        //TODO: date picker, date value stored, on image view click

         datepickerbetweenstation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog dialog = new DatePickerDialog(TrainbtwnEnqAct.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        str = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;

                        dateofmonth = year + "" + "0" + (monthOfYear + 1) + "" +dayOfMonth;
                        imagepickertextset.setText(str);
                        Log.d("-  date is---", str);
                        String dateResponse2 = reversedatestring;

                    }
                }, 2017, 06, 10);
                dialog.show();
            }
        });


        //TODO: button show trains passing the data to list activity
        showtrains.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!(str.equals("") || str.equals(null) ||
                        TextUtils.isEmpty(sourcestationcodeedittext.getText().toString()) ||
                        TextUtils.isEmpty(destinationstationcodeedittext.getText().toString()))) {

                    String name1 = sourcestationcodeedittext.getText().toString();
                    String name2 = destinationstationcodeedittext.getText().toString();

                    String fromCode = name1.substring(name1.indexOf("(") + 1, name1.indexOf(")"));
                    String toCode = name2.substring(name2.indexOf("(") + 1, name2.indexOf(")"));

                    Intent intent = new Intent(TrainbtwnEnqAct.this, TrnListActi.class);
                    intent.putExtra("parameter1", /*sourcestationcodeString*/fromCode);
                    intent.putExtra("paramater2", /*destinationstationcodeString*/toCode);
                    intent.putExtra("parameter3", imagepickertextset.getText().toString());
                    startActivity(intent);
                } else {
                    Snackbar snackbar = Snackbar.make(container_linear_layout, "please select date", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            }
        });
    }
}
