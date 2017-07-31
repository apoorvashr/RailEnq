package com.example.apoo.railwayprojectapoorva.view.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.apoo.railwayprojectapoorva.R;
import com.example.apoo.railwayprojectapoorva.util.MySharedPrefrence;
import com.example.apoo.railwayprojectapoorva.view.drawer.DrawerActivity;
import com.example.apoo.railwayprojectapoorva.view.loginsignup.LoginActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    if (MySharedPrefrence.getLoginMessage(SplashScreen.this) == 0) {
                        Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
                        SplashScreen.this.startActivity(intent);
                        finish();

                    } else {

                        Intent intent = new Intent(SplashScreen.this, DrawerActivity.class);
                        SplashScreen.this.startActivity(intent);
                        finish();
                    }
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }

            }
        }).start();

    }
}