package com.example.apoo.railwayprojectapoorva.view.aboutus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.example.apoo.railwayprojectapoorva.R;
import butterknife.BindView;
import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;


/**
 * The type About us activity.
 *//*
public class AboutUsActivity extends AppCompatActivity {

    *//**
     * About us Activity
     *//*
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);
       // toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("About Us");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
*//*
        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setDescription(getString(R.string.spaces))
                .setImage(R.mipmap.ic_train)
                .addItem(new Element().setTitle(getString(R.string.version)))
                .addWebsite("https://apoorva223.blogspot.com")
                .addGroup("Connect with us")
                .addEmail("apoorva.shr@gmail.com")
                .create();
        setContentView(aboutPage);*//*

    }

}*/



/**
 * The type About us activity.
 */
public class AboutUsActivity extends AppCompatActivity {

    /**
     * About us Activity
     */

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);
        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setDescription(getString(R.string.spaces))
                .setImage(R.mipmap.ic_train)
                .addItem(new Element().setTitle(getString(R.string.version)))
                .addGroup(getString(R.string.connect_with_us))
                .addWebsite("https://apoorva223.blogspot.com")
                .addEmail("apoorva.shr@gmail.com")
                .create();
        setContentView(aboutPage);

    }

}
