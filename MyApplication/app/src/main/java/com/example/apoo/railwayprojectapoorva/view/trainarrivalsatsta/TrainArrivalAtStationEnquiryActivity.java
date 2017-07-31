package com.example.apoo.railwayprojectapoorva.view.trainarrivalsatsta;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;


import com.example.apoo.railwayprojectapoorva.R;
import com.example.apoo.railwayprojectapoorva.adapter.autocompadap.AutoCompleteStationAdapter;

public class TrainArrivalAtStationEnquiryActivity extends AppCompatActivity {

    ImageView imageViewHourpicker;
    TextView  textViewHourSelected;
    AutoCompleteTextView editTextStationCode;
    LinearLayout linearLayoutContainer;
    NumberPicker numberPicker;
    Button buttonsearchtrainarrivals;
    int newValue;
    String newValuess = "";
    AutoCompleteStationAdapter adapter;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_arrival_enq);

        editTextStationCode = (AutoCompleteTextView) findViewById(R.id.stationcodeet);
        imageViewHourpicker = (ImageView) findViewById(R.id.imageviewselecthour);
        textViewHourSelected= (TextView) findViewById(R.id.imageviewHourselectedtextview);
        linearLayoutContainer = (LinearLayout) findViewById(R.id.linearLayoutContainer);
        buttonsearchtrainarrivals = (Button) findViewById(R.id.btn_search_trains_arrival);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("About Us");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        adapter = new AutoCompleteStationAdapter(this, android.R.layout.simple_dropdown_item_1line);

        //when autocomplete is clicked
        editTextStationCode.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String stationName = adapter.getItem(position).getName();
                editTextStationCode.setText(stationName);
            }
        });

        editTextStationCode.setAdapter(adapter);
        imageViewHourpicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showalertdialog();
            }
        });

        buttonsearchtrainarrivals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(editTextStationCode.getText().toString().trim())  ||
                        TextUtils.isEmpty(textViewHourSelected.getText().toString().trim())) {

                    Snackbar snackbar = Snackbar.make(linearLayoutContainer, getString(R.string.fill_all_the_fields), Snackbar.LENGTH_SHORT);
                    snackbar.show(); }
                else if (newValuess.equals("") || newValuess.equals(null)) {
                    Snackbar snackbar = Snackbar.make(linearLayoutContainer, getString(R.string.please_select_value_multiple), Snackbar.LENGTH_SHORT);
                    snackbar.show();
                } else if (!(TextUtils.isEmpty(textViewHourSelected.getText().toString().trim()))) {
                    Intent intent = new Intent(TrainArrivalAtStationEnquiryActivity.this, TrainarrivalatStationConnectionActivity.class);
                    intent.putExtra("parameter1", editTextStationCode.getText().toString());
                    intent.putExtra("parameter2", textViewHourSelected.getText().toString());
                    startActivity(intent);
                }  else  {
                    Snackbar snackbar = Snackbar.make(linearLayoutContainer, getString(R.string.fill_all_the_fields), Snackbar.LENGTH_SHORT);
                    snackbar.show();
                }
            }
        });
    }

    private void showalertdialog() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.layout_dialog_box_hour_selection_train_arrival, null);
        builder.setCancelable(false);

        numberPicker = (NumberPicker) view.findViewById(R.id.numberPicker);
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(4);
        numberPicker.setWrapSelectorWheel(false);
        builder.setView(view);

        //Set a value change listener for NumberPicker
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                //Display the newly selected number from picker
                 newValuess= String.valueOf(newVal);
                textViewHourSelected.setText(newValuess);
                newValue = newVal;
            }
        });


        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                builder.setCancelable(true);
            }
        });
        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (newValue == 0){
                    Toast.makeText(TrainArrivalAtStationEnquiryActivity.this, getString(R.string.please_select_hour_value), Toast.LENGTH_SHORT).show();
                    builder.setCancelable(false);
                } else if (newValue==2) {
                    dialog.cancel();
                    builder.setCancelable(true);
                   /* Snackbar snackbar = Snackbar.make(linearLayoutContainer, getString(R.string.hour_selected), Snackbar.LENGTH_SHORT);
                    snackbar.show();*/
                } else if(newValue==3 || newValue==1) {
                    Toast.makeText(TrainArrivalAtStationEnquiryActivity.this, getString(R.string.please_select_value_multiple), Toast.LENGTH_SHORT).show();
                    builder.setCancelable(false);
                }
            }
        });
        final AlertDialog dialog = builder.create();
        dialog.show();
    }
}
