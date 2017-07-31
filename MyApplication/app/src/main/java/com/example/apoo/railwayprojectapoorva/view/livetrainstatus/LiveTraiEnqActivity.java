package com.example.apoo.railwayprojectapoorva.view.livetrainstatus;

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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.apoo.railwayprojectapoorva.R;
import com.example.apoo.railwayprojectapoorva.adapter.autocompadap.AutoCompleteTrainAdapter;

public class LiveTraiEnqActivity extends AppCompatActivity {

    public String reversedatevalue;
    String dateofmonth;
    TextView textViewImgDateSelected;
    ImageView imageViewSelectDate;
    Button buttonSearchliveTrain;
    AutoCompleteTextView editTextTrainnumber;
    AutoCompleteTrainAdapter adapter;
    LinearLayout container_linear_layout;
    String str = "";
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_trai);

        editTextTrainnumber = (AutoCompleteTextView) findViewById(R.id.trainnumberlivemod);
        buttonSearchliveTrain = (Button) findViewById(R.id.btn_search_train);
        imageViewSelectDate = (ImageView) findViewById(R.id.imageviewselectdate);
        textViewImgDateSelected = (TextView) findViewById(R.id.imageviewDateselectedtextview);
        container_linear_layout = (LinearLayout)findViewById(R.id.container_linear_layout);
        adapter = new AutoCompleteTrainAdapter(this, android.R.layout.simple_dropdown_item_1line);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("About Us");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //when autocomplete is clicked
        editTextTrainnumber.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String trainName = adapter.getItem(position).getName();
                editTextTrainnumber.setText(trainName);
            }
        });

        editTextTrainnumber.setAdapter(adapter);


        //TODO: imageview to take a date from picker, setting on textview
        imageViewSelectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog dialog = new DatePickerDialog(LiveTraiEnqActivity.this, new DatePickerDialog.OnDateSetListener() {
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
        buttonSearchliveTrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String trainName = editTextTrainnumber.getText().toString();
                String stringDate = textViewImgDateSelected.getText().toString();

     if (TextUtils.isEmpty(editTextTrainnumber.getText().toString())) {
                    Snackbar snackbar = Snackbar.make(container_linear_layout, "please fill all the fields", Snackbar.LENGTH_LONG);
                    snackbar.show();
                } else if (!(str.equals("") || str.equals(null)))  {
                    String trainNumber = trainName.substring(trainName.indexOf("(") + 1, trainName.indexOf(")"));
                    Intent intent = new Intent(LiveTraiEnqActivity.this, LiveTrainConActivity.class);
                    intent.putExtra("paramater1",/*editTextTrainnumber.getText().toString()*/trainNumber);
                    intent.putExtra("parameter2",textViewImgDateSelected.getText().toString());
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
