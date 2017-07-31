package com.example.apoo.railwayprojectapoorva.view.info;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.widget.TextView;
import com.example.apoo.railwayprojectapoorva.R;

public class InfoAct extends AppCompatActivity {

    TextView about;
    Toolbar toolbar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        about = (TextView) findViewById(R.id.id_about);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Info");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        about.setText(Html.fromHtml("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\">\t\n" +
                "</head>\n" +
                "\n"+
                "\n"+
                "<body lang=\"en-IN\" text=\"#000000\" dir=\"LTR\">\n" +

                "<p>        this app uses the RAILWAYAPI server"+
                ", you can easily find the trains between 2 stations\n" +
                ", can easily check train fare\n"+
                ", cancelled train details are also available on a single click\n"+
                ", rescheduled train details are available\n"+
                ", used some third party open source libraries, hope you liked the app</p>\n"+
                "</li></ol>\n" +
                "\n" +
                "</body>" +
                "</html>"));
    }
}
