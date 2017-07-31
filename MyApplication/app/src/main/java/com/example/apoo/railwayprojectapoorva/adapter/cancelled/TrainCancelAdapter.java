package com.example.apoo.railwayprojectapoorva.adapter.cancelled;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.apoo.railwayprojectapoorva.R;
import com.example.apoo.railwayprojectapoorva.entities.cancel.Cancel;
import com.example.apoo.railwayprojectapoorva.entities.live.Live;

import java.util.ArrayList;

/**
 * Created by Apoo on 6/15/2017.
 */

public class TrainCancelAdapter extends RecyclerView.Adapter<TrainCancelAdapter.ViewHolder> {

    private Context context;
    ArrayList<Cancel> fillsingleRow;


    //constructor
    public TrainCancelAdapter(Context context, ArrayList<Cancel> fillsingleRow) {
        this.fillsingleRow = fillsingleRow;
        this.context = context;

    }


    @Override
    public TrainCancelAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_row_item_train_cancel,parent,false);

        TrainCancelAdapter.ViewHolder vh = new TrainCancelAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(TrainCancelAdapter.ViewHolder holder, int position) {

        holder.trainName.setText(fillsingleRow.get(position).getTrainName());
        holder.sourceStationName.setText(fillsingleRow.get(position).getSourceStationName());
        holder.trainnumber.setText(fillsingleRow.get(position).getTrainNumber());
        holder.type.setText(fillsingleRow.get(position).getType());
        holder.starttime.setText(fillsingleRow.get(position).getStartTime());
        holder.destinationStationName.setText(fillsingleRow.get(position).getDestinationName());

    }

    @Override
    public int getItemCount() {
        return fillsingleRow.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView trainName;
        TextView sourceStationName;
        TextView destinationStationName,trainnumber;
        TextView type;
        TextView starttime;

        public ViewHolder(View itemView) {

            super(itemView);
            trainName = (TextView) itemView.findViewById(R.id.train_name_tv);
            sourceStationName = (TextView) itemView.findViewById(R.id.source_station_name_tv);
            destinationStationName = (TextView) itemView.findViewById(R.id.destination_station_name_tv);
            trainnumber = (TextView) itemView.findViewById(R.id.train_number_tv);
            type = (TextView)itemView.findViewById(R.id.train_type_tv);
            starttime = (TextView) itemView.findViewById(R.id.train_start_time_tv);

            }

    }
}
