package com.example.apoo.railwayprojectapoorva.view.root;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.apoo.railwayprojectapoorva.R;
import com.example.apoo.railwayprojectapoorva.adapter.trainroot.TrainRootAdapter;
import com.example.apoo.railwayprojectapoorva.adapter.trainroot.TrainRootClassesAdapter;
import com.example.apoo.railwayprojectapoorva.entities.root.RootClasses;
import com.onurciner.fontchange.FTextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class TainRootClassesActivity extends AppCompatActivity {


    TextView tvClasscode1,tvclasscode2,tvclasscode3,tvclasscode4,tvclasscode5,tvclasscode6,tvclasscode7,tvclasscode8;
    TextView availiability1,availiability2,availiability3,availiability4,availiability5,availiability6,availiability7,availiability8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tain_root_classes_activity);

         tvClasscode1 = (TextView) findViewById(R.id.Class_code_tv_1) ;
         tvclasscode2 = (TextView) findViewById(R.id.Class_code_tv_2);
         tvclasscode3 = (TextView) findViewById(R.id.Class_code_tv_3);
         tvclasscode4 = (TextView) findViewById(R.id.Class_code_tv_4);
         tvclasscode5 = (TextView) findViewById(R.id.Class_code_tv_5);
         tvclasscode6 = (TextView) findViewById(R.id.Class_code_tv_6);
         tvclasscode7 = (TextView) findViewById(R.id.Class_code_tv_7);
         tvclasscode8 = (TextView) findViewById(R.id.Class_code_tv_8);
        availiability1 = (TextView) findViewById(R.id.class_availibility_1);
        availiability2 = (TextView) findViewById(R.id.class_availibility_2);
        availiability3 = (TextView) findViewById(R.id.class_availibility_3);
        availiability4 = (TextView) findViewById(R.id.class_availibility_4);
        availiability5 = (TextView) findViewById(R.id.class_availibility_5);
        availiability6 = (TextView) findViewById(R.id.class_availibility_6);
        availiability7 = (TextView) findViewById(R.id.class_availibility_7);
        availiability8 = (TextView) findViewById(R.id.class_availibility_8);

        Intent i = getIntent();
        RootClasses dene = (RootClasses)i.getSerializableExtra("object");

        tvClasscode1.setText(dene.getClasscode());
        availiability1.setText(dene.getAvailablity());

        tvclasscode2.setText(dene.getClasscode());
        availiability2.setText(dene.getAvailablity());

    }
}
