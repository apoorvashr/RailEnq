package com.example.apoo.railwayprojectapoorva.view.loginsignup;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.apoo.railwayprojectapoorva.R;
import com.example.apoo.railwayprojectapoorva.util.MySharedPrefrence;

public class LoginActivity extends AppCompatActivity {

    ProgressBar progressBar;
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator_container);

    }


    //TODO: error condition case
    public void showError() {
        MySharedPrefrence.setLoginMessage(this, 0);
        if (progressBar != null) progressBar.setVisibility(View.GONE);;
       // Toast.makeText(this, error, Toast.LENGTH_SHORT).show();

            Snackbar snackbar = Snackbar.make(coordinatorLayout, "Something went wrong please try again!!", Snackbar.LENGTH_LONG);
            snackbar.show();
    }
}
