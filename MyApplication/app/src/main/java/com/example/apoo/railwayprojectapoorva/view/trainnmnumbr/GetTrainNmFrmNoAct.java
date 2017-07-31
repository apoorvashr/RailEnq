package com.example.apoo.railwayprojectapoorva.view.trainnmnumbr;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.example.apoo.railwayprojectapoorva.R;
import com.example.apoo.railwayprojectapoorva.entities.trainnmfromnmbr.TainNameNumberResponse;
import com.example.apoo.railwayprojectapoorva.presenter.trainnmfrmnmbr.TrainnamefrmnumberPre;

public class GetTrainNmFrmNoAct extends AppCompatActivity implements Gettrainnameornmbrview {


    private TextView trainNumber,trainname;
    private ViewPager mViewPager;
    private CardPagerAdapter mCardAdapter;
    TrainnamefrmnumberPre presenter;
    private final String APIKEY = "01u8xbb1";
    int daycode,abc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout./*activity_get_tain_name_from_number*/layout12);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        trainNumber = (TextView) findViewById(R.id.textview_number_tnttn);
        trainname = (TextView) findViewById(R.id.Train_name_train_name_to_number);

        //presenter = new TrainnamefrmnumPreImp(this,new ApiClient(this.getBaseContext()));

        Bundle bundle = getIntent().getExtras();
        String para1 = bundle.getString("string");
        //presenter.getTrainsBetweenStations(para1, APIKEY);
        Intent intent = getIntent();
        TainNameNumberResponse dene = (TainNameNumberResponse)intent.getSerializableExtra("object");

        trainNumber.setText(dene.getTrain().getNumber());
        trainname.setText(dene.getTrain().getName());

        mCardAdapter = new CardPagerAdapter();

        mViewPager.setAdapter(mCardAdapter);

        //TODO: sunday
        switch(dene.getTrain().getDays().get(0).getRuns()) {
            case "N":
                mCardAdapter.addCardItem(new CardItem(R.string.title_0, R.string.text_2));
                mCardAdapter.notifyDataSetChanged();
                break;

            case "Y":
                mCardAdapter.addCardItem(new CardItem(R.string.title_0, R.string.text_1));
                mCardAdapter.notifyDataSetChanged();
                break;
        }


        // TODO: monday
        switch(dene.getTrain().getDays().get(1).getRuns()) {
            case "N":
                mCardAdapter.addCardItem(new CardItem(R.string.title_1, R.string.text_2));
                mCardAdapter.notifyDataSetChanged();
                break;

            case "Y":
                mCardAdapter.addCardItem(new CardItem(R.string.title_1, R.string.text_1));
                mCardAdapter.notifyDataSetChanged();
                break;
        }


        // TODO: tuesday
        switch(dene.getTrain().getDays().get(2).getRuns()) {
            case "N":
                mCardAdapter.addCardItem(new CardItem(R.string.title_2, R.string.text_2));
                mCardAdapter.notifyDataSetChanged();
                break;

            case "Y":
                mCardAdapter.addCardItem(new CardItem(R.string.title_2, R.string.text_1));
                mCardAdapter.notifyDataSetChanged();
                break;
        }


        // TODO: wednesday
        switch(dene.getTrain().getDays().get(3).getRuns()) {
            case "N":
                mCardAdapter.addCardItem(new CardItem(R.string.title_3, R.string.text_2));
                mCardAdapter.notifyDataSetChanged();
                break;

            case "Y":
                mCardAdapter.addCardItem(new CardItem(R.string.title_3, R.string.text_1));
                mCardAdapter.notifyDataSetChanged();
                break;
        }

        // TODO: thrusday
        switch(dene.getTrain().getDays().get(4).getRuns()) {
            case "N":
                mCardAdapter.addCardItem(new CardItem(R.string.title_4, R.string.text_2));
                mCardAdapter.notifyDataSetChanged();
                break;

            case "Y":
                mCardAdapter.addCardItem(new CardItem(R.string.title_4, R.string.text_1));
                mCardAdapter.notifyDataSetChanged();
                break;
        }

        // TODO: friday
        switch(dene.getTrain().getDays().get(5).getRuns()) {
            case "N":
                mCardAdapter.addCardItem(new CardItem(R.string.title_5, R.string.text_2));
                mCardAdapter.notifyDataSetChanged();
                break;

            case "Y":
                mCardAdapter.addCardItem(new CardItem(R.string.title_5, R.string.text_1));
                mCardAdapter.notifyDataSetChanged();
                break;
        }

        // TODO: saturday
        switch(dene.getTrain().getDays().get(6).getRuns()) {
            case "N":
                mCardAdapter.addCardItem(new CardItem(R.string.title_6, R.string.text_2));
                mCardAdapter.notifyDataSetChanged();
                break;

            case "Y":
                mCardAdapter.addCardItem(new CardItem(R.string.title_6, R.string.text_1));
                mCardAdapter.notifyDataSetChanged();
                break;
        }

    }

    //TODO: interfaces overrided method
    @Override
    public void onSuccess(TainNameNumberResponse tainNameNumberResponse) {

        trainNumber.setText(tainNameNumberResponse.getTrain().getNumber());
        trainname.setText(tainNameNumberResponse.getTrain().getName());
        Log.d("", "onSuccess: 2nd activity "+tainNameNumberResponse.getResponseCode() );
      //  List<Day> dayslist = tainNameNumberResponse.getTrain().getDays();
      //   daycode = Integer.parseInt(dayslist.get(0).getDayCode());
       //  abc = Integer.parseInt("no title");


    }


    //TODO: interface overrided method
    @Override
    public void onFailure(String error) {

    }
}
