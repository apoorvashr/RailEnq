package com.example.apoo.railwayprojectapoorva.view.trainfare;

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
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.apoo.railwayprojectapoorva.R;
import com.example.apoo.railwayprojectapoorva.adapter.autocompadap.AutoCompleteStationAdapter;
import com.example.apoo.railwayprojectapoorva.adapter.autocompadap.AutoCompleteTrainAdapter;

public class TrainFareEnquiAct extends AppCompatActivity  {

    AutoCompleteTextView editTextTrainnumber;
    AutoCompleteTextView editTextsourcestation, editTextsestinationstation;
    EditText editTextPassengerAge;
    Spinner spinnerSelectQota;
    Button buttonSearchfare;
    ImageView imageViewSelectDate;
    TextView textViewImgDateSelected;
    public String reversedatevalue;
    String dateofmonth;
    private String selectedQuota;
    AutoCompleteStationAdapter adapter;
    AutoCompleteStationAdapter adapter2;
    AutoCompleteTrainAdapter adapter3;
    LinearLayout linear_container_layout;
    String str = "";
    private Integer selectedIndexSpinnerStatus;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_fare_enq_new);

        editTextTrainnumber = (AutoCompleteTextView) findViewById(R.id.trainnumber);
        editTextsourcestation = (AutoCompleteTextView) findViewById(R.id.sourcestationedittext);
        editTextsestinationstation = (AutoCompleteTextView) findViewById(R.id.destinationstationet);
        editTextPassengerAge = (EditText) findViewById(R.id.passengersage);
        spinnerSelectQota = (Spinner) findViewById(R.id.spinner_select_quota);
        buttonSearchfare = (Button) findViewById(R.id.btn_search_fare);
        imageViewSelectDate = (ImageView) findViewById(R.id.imageviewselectdate);
        textViewImgDateSelected = (TextView) findViewById(R.id.imageviewDateselectedtextview);
        linear_container_layout = (LinearLayout) findViewById(R.id.container_linear_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Train Fare");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        adapter = new AutoCompleteStationAdapter(this, android.R.layout.simple_dropdown_item_1line);
        adapter2 = new AutoCompleteStationAdapter(this, android.R.layout.simple_dropdown_item_1line);
        adapter3 = new AutoCompleteTrainAdapter(this, android.R.layout.simple_dropdown_item_1line);

        //TODO: when autocomplete is clicked
        editTextsourcestation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String stationName = adapter.getItem(position).getName();
                editTextsourcestation.setText(stationName);
            }
        });
        editTextsourcestation.setAdapter(adapter);

        //TODO: when autocomplete is clicked
        editTextTrainnumber.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String stationName = adapter3.getItem(position).getName();
                editTextTrainnumber.setText(stationName);
            }
        });

        editTextTrainnumber.setAdapter(adapter3);

        //TODO: when autocomplete is clicked
        editTextsestinationstation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String stationName = adapter2.getItem(position).getName();
                editTextsestinationstation.setText(stationName);
            }
        });

        editTextsestinationstation.setAdapter(adapter2);

        //TODO: imageview to take a date from picker, setting on textview
        imageViewSelectDate.setOnClickListener(new View.OnClickListener() {
            @Override
       public void onClick(View view) {

       DatePickerDialog dialog = new DatePickerDialog(TrainFareEnquiAct.this, new DatePickerDialog.OnDateSetListener() {
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

        ArrayAdapter<String> SelectDayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.spinner));
        SelectDayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSelectQota.setAdapter(SelectDayAdapter);

        //TODo spinner Add day item selected listener
        spinnerSelectQota.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                selectedIndexSpinnerStatus = spinnerSelectQota.getSelectedItemPosition();
                selectedQuota = parent.getItemAtPosition(position).toString();

                switch (selectedIndexSpinnerStatus) {
                    case 0:
                        selectedQuota = "";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                selectedQuota = "";
            }

        });

      //TODO: calling presenter from view requesting for data from server
        buttonSearchfare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Intent intent = new Intent (TrainFareEnquiAct.this, TrainFareConneActi.class);
                intent.putExtra("paramater1",editTextTrainnumber.getText().toString());
                intent.putExtra("paramater2",editTextsourcestation.getText().toString());
                intent.putExtra("parameter3",editTextsestinationstation.getText().toString());
                intent.putExtra("parameter4",editTextPassengerAge.getText().toString());
                intent.putExtra("parameter5",selectedQuota);
                intent.putExtra("parameter6",textViewImgDateSelected.getText().toString());
                startActivity(intent);
*/

                if (!(str.equals("") || str.equals(null) ||
                        TextUtils.isEmpty(editTextsourcestation.getText().toString()) ||
                        TextUtils.isEmpty(editTextsestinationstation.getText().toString()) ||
                        TextUtils.isEmpty(editTextPassengerAge.getText().toString())
                        ||selectedQuota.equals("") || selectedQuota.equals(null) || selectedIndexSpinnerStatus.equals(0))) {

                    String name1 = editTextsourcestation.getText().toString();
                    String name2 = editTextsestinationstation.getText().toString();

                    String fromCode = name1.substring(name1.indexOf("(") + 1, name1.indexOf(")"));
                    String toCode = name2.substring(name2.indexOf("(") + 1, name2.indexOf(")"));

                    String trainName = editTextTrainnumber.getText().toString();
                    String trainNumber = trainName.substring(trainName.indexOf("(") + 1, trainName.indexOf(")"));

                    Intent intent = new Intent (TrainFareEnquiAct.this, TrainFareConneActi.class);
                    intent.putExtra("paramater1",/*editTextTrainnumber.getText().toString()*/trainNumber);
                    intent.putExtra("paramater2",/*editTextsourcestation.getText().toString()*/fromCode);
                    intent.putExtra("parameter3",/*editTextsestinationstation.getText().toString()*/toCode);
                    intent.putExtra("parameter4",editTextPassengerAge.getText().toString());
                    intent.putExtra("parameter5",selectedQuota);
                    intent.putExtra("parameter6",textViewImgDateSelected.getText().toString());
                    startActivity(intent);
                }


                else {
                    Snackbar snackbar = Snackbar.make(linear_container_layout, "please fill all the fields", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            }
        });
    }
}
