package com.example.apoo.railwayprojectapoorva.view.trainnmnumbr;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import com.example.apoo.railwayprojectapoorva.R;
import com.example.apoo.railwayprojectapoorva.adapter.autocompadap.AutoCompleteTrainAdapter;
import com.example.apoo.railwayprojectapoorva.api.ApiClient;
import com.example.apoo.railwayprojectapoorva.entities.trainnmfromnmbr.TainNameNumberResponse;
import com.example.apoo.railwayprojectapoorva.presenter.trainnmfrmnmbr.TrainnamefrmnumPreImp;
import com.example.apoo.railwayprojectapoorva.presenter.trainnmfrmnmbr.TrainnamefrmnumberPre;

public class TraiNmEnquiAct extends AppCompatActivity implements Gettrainnameornmbrview {

    AutoCompleteTextView trainnameEditText;
    TrainnamefrmnumberPre presenter;
    Button btnshowtraindetails;
    private final String APIKEY = "01u8xbb1";
    AutoCompleteTrainAdapter adapter;
    LinearLayout linear_container;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_running_day_enq);
        trainnameEditText= (AutoCompleteTextView) findViewById(R.id.trainnameornumberet);
        btnshowtraindetails = (Button) findViewById(R.id.btn_show_details);
        presenter=new TrainnamefrmnumPreImp(this,new ApiClient(this.getBaseContext()));
        linear_container = (LinearLayout) findViewById(R.id.linear_container);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Train Running Day");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        adapter = new AutoCompleteTrainAdapter(this, android.R.layout.simple_dropdown_item_1line);

        //TODO: when autocomplete is clicked
        trainnameEditText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String stationName = adapter.getItem(position).getName();
                trainnameEditText.setText(stationName);
            }
        });

        trainnameEditText.setAdapter(adapter);

        btnshowtraindetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("", "onClick: ");
                if (!(trainnameEditText.getText().toString().equals(""))) {
                    String trainName = trainnameEditText.getText().toString();
                    String trainNumber = trainName.substring(trainName.indexOf("(") + 1, trainName.indexOf(")"));
                    presenter.getTrainsBetweenStations(trainNumber, APIKEY);

                } else {
                    Snackbar snackbar = Snackbar.make(linear_container, "please fill all the fields", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            }

        });

    }

    @Override
    public void onSuccess(TainNameNumberResponse tainNameNumberResponse) {

        TainNameNumberResponse response = tainNameNumberResponse;

        Log.d("", "onSuccess: "+tainNameNumberResponse.toString());

        Intent intent  = new Intent(TraiNmEnquiAct.this, GetTrainNmFrmNoAct.class);
        intent.putExtra("object",response);
        intent.putExtra("String",trainnameEditText.getText().toString());
        startActivity(intent);
    }

    @Override
    public void onFailure(String error) {

        Log.d("", "onFailure: "+error);
    }
}
