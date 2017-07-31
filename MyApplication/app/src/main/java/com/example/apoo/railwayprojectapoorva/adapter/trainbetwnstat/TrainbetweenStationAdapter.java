package com.example.apoo.railwayprojectapoorva.adapter.trainbetwnstat;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.apoo.railwayprojectapoorva.R;
import com.example.apoo.railwayprojectapoorva.entities.trainbtwnstat.SinglerowItemfill;
import com.example.apoo.railwayprojectapoorva.view.trainbetweensta.TrainDtlsPgActiv;

import java.util.ArrayList;

/**
 * Created by Apoo on 5/26/2017.
 */

public class TrainbetweenStationAdapter extends BaseAdapter  {

    ArrayList<SinglerowItemfill> fillsingleRow;
    Context context;
    Button showDetailsOfTrainBtn;
    TextView sourceStation;
    TextView destinationStation;
    TextView trainNumber;
    TextView trainName;

    //constructor
    public TrainbetweenStationAdapter(Context context, ArrayList<SinglerowItemfill> fillsingleRow) {
        this.fillsingleRow = fillsingleRow;
        this.context = context;
    }

    @Override
    public int getCount() {
        return fillsingleRow.size();
    }

    @Override
    public Object getItem(int position) {
        return fillsingleRow.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View singleRowItem = inflater.inflate(R.layout.single_row_item_train_between_details,null);

        showDetailsOfTrainBtn = (Button) singleRowItem.findViewById(R.id.show_train_details_page_btn);
        trainNumber = (TextView) singleRowItem.findViewById(R.id.textview_train_number);
        trainName = (TextView) singleRowItem.findViewById(R.id.textview_train_name);
        destinationStation = (TextView)singleRowItem.findViewById(R.id.textview_destination_station);
        sourceStation = (TextView)singleRowItem.findViewById(R.id.textview_source_station);

        sourceStation.setText(fillsingleRow.get(position).getFromCode());
        destinationStation.setText(fillsingleRow.get(position).getToCode());
        trainName.setText(fillsingleRow.get(position).getTrainName());
        trainNumber.setText(fillsingleRow.get(position).getTrainNumber());
        singleRowItem.setClickable(true);
        final Context context = singleRowItem.getContext();
        showDetailsOfTrainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, TrainDtlsPgActiv.class);
                intent.putExtra("fromstation", fillsingleRow.get(position).getFromCode());
                intent.putExtra("tostation", fillsingleRow.get(position).getToCode());
                intent.putExtra("departuretime",fillsingleRow.get(position).getDepatureTime());
                intent.putExtra("arrivaltime",fillsingleRow.get(position).getArrivalTime());
                intent.putExtra("traveltime",fillsingleRow.get(position).getTravelTime());
                intent.putExtra("trainnumber",fillsingleRow.get(position).getTrainNumber());
                intent.putExtra("trainname",fillsingleRow.get(position).getTrainName());



                context.startActivity(intent);
            }
        });

        return singleRowItem;
    }

}
