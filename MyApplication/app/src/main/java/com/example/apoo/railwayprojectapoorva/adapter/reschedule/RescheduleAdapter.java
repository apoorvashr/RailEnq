package com.example.apoo.railwayprojectapoorva.adapter.reschedule;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.apoo.railwayprojectapoorva.R;
import com.example.apoo.railwayprojectapoorva.entities.reschedule.Reschedule;

import java.util.ArrayList;

/**
 * Created by Apoo on 6/15/2017.
 */

public class RescheduleAdapter extends RecyclerView.Adapter<RescheduleAdapter.ViewHolder> {

    private Context context;
    ArrayList<Reschedule> fillsingleRow;


    //constructor
    public RescheduleAdapter(Context context, ArrayList<Reschedule> fillsingleRow) {
        this.fillsingleRow = fillsingleRow;
        this.context = context;

    }


    @Override
    public RescheduleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_row_item_rechedule_train,parent,false);

        RescheduleAdapter.ViewHolder vh = new RescheduleAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RescheduleAdapter.ViewHolder holder, int position) {

        holder.trainName.setText(fillsingleRow.get(position).getTrainName());
        holder.sourceStationName.setText(fillsingleRow.get(position).getFromStationName());
        holder.trainnumber.setText(fillsingleRow.get(position).getTrainNumber());
        holder.timeDifference.setText(fillsingleRow.get(position).getTime_diff());
        holder.rescheduledTime.setText(fillsingleRow.get(position).getRescheduled_time());
        holder.destinationStationName.setText(fillsingleRow.get(position).getToStationName());
        holder.rescheduledDate.setText(fillsingleRow.get(position).getRescheduled_date());
    }

    @Override
    public int getItemCount() {
        return fillsingleRow.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView trainName;
        TextView sourceStationName;
        TextView destinationStationName,trainnumber;
        TextView timeDifference;
        TextView rescheduledTime,rescheduledDate;

        public ViewHolder(View itemView) {

            super(itemView);
            trainName = (TextView) itemView.findViewById(R.id.train_name_tv);
            sourceStationName = (TextView) itemView.findViewById(R.id.from_station_name_tv);
            destinationStationName = (TextView) itemView.findViewById(R.id.to_station_name_tv);
            trainnumber = (TextView) itemView.findViewById(R.id.train_number_tv);
            timeDifference = (TextView)itemView.findViewById(R.id.time_difference_tv);
            rescheduledTime = (TextView) itemView.findViewById(R.id.rescheduled_time_tv);
            rescheduledDate = (TextView) itemView.findViewById(R.id.train_rescheduled_date_tv);
            }

    }
}
