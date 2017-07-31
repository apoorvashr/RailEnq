package com.example.apoo.railwayprojectapoorva.view.root;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import com.example.apoo.railwayprojectapoorva.R;
import com.example.apoo.railwayprojectapoorva.adapter.autocompadap.AutoCompleteTrainAdapter;

public class TrainRootEnqActivity extends AppCompatActivity {

    AutoCompleteTextView editTextTrainRoot;
    Button btnSearchTrainRoot;
    AutoCompleteTrainAdapter adapter;
    LinearLayout container_linear_layout;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_root_enq);

        editTextTrainRoot = (AutoCompleteTextView) findViewById(R.id.trainnumberId);
        btnSearchTrainRoot = (Button) findViewById(R.id.btn_search_trains_root);
        container_linear_layout = (LinearLayout)findViewById(R.id.container_linear_layout);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Train Root");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        adapter = new AutoCompleteTrainAdapter(this, android.R.layout.simple_dropdown_item_1line);

        //TODO: when autocomplete is clicked
        editTextTrainRoot.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String trainName = adapter.getItem(position).getName();
                editTextTrainRoot.setText(trainName);
            }
        });

        editTextTrainRoot.setAdapter(adapter);
        btnSearchTrainRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(editTextTrainRoot.getText().toString())) {
                    Snackbar snackbar = Snackbar.make(container_linear_layout, "please fill all the fields", Snackbar.LENGTH_LONG);
                    snackbar.show();
                   }  else {

                    String trainName = editTextTrainRoot.getText().toString();
                    String trainNumber = trainName.substring(trainName.indexOf("(") + 1, trainName.indexOf(")"));

                    Intent intent = new Intent(TrainRootEnqActivity.this, TrainRootConnActivity.class);
                    intent.putExtra("paramater1",/*editTextTrainRoot.getText().toString()*/trainNumber);
                    startActivity(intent);
                   }
            }
        });
    }
}
