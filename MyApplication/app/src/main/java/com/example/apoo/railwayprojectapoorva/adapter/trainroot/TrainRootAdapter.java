package com.example.apoo.railwayprojectapoorva.adapter.trainroot;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.apoo.railwayprojectapoorva.R;
import com.example.apoo.railwayprojectapoorva.entities.root.Root;
import com.example.apoo.railwayprojectapoorva.entities.root.RootClasses;

import java.util.ArrayList;

/**
 * Created by Apoo on 6/15/2017.
 */

public class TrainRootAdapter extends RecyclerView.Adapter<TrainRootAdapter.ViewHolder> {

    private Context context;
    ArrayList<Root> fillsingleRow;
    ArrayList<RootClasses> fillsingleRow2;


    //constructor
    public TrainRootAdapter(Context context, ArrayList<Root> fillsingleRow/*, ArrayList<RootClasses> fillsingleRow2*/) {
        this.fillsingleRow = fillsingleRow;
        this.fillsingleRow2 = fillsingleRow2;
        this.context = context;
    }


    @Override
    public TrainRootAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_row_item_train_root_activity,parent,false);

        TrainRootAdapter.ViewHolder vh = new TrainRootAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(TrainRootAdapter.ViewHolder holder, int position) {

        holder.trainname.setText(fillsingleRow.get(position).getFullname());
       // holder.trainnumbertextview.setText(fillsingleRow2.get(position).getTrainnumber());
        holder.rootNumberTv.setText(fillsingleRow.get(position).getRootNumber());
        holder. scheduleDeparture.setText(fillsingleRow.get(position).getSchdep());
        holder.scheduleArrival.setText(fillsingleRow.get(position).getScharr());
        holder.stationname.setText(fillsingleRow.get(position).getFullname());
        holder.halt.setText(fillsingleRow.get(position).getHalt());
        holder.distance.setText(fillsingleRow.get(position).getDistance());

    }

    @Override
    public int getItemCount() {
        return fillsingleRow.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView trainname;
        TextView trainnumbertextview;
        TextView rootNumberTv;
        TextView scheduleDeparture,scheduleArrival;
        TextView distance, stationname,halt;

        final Context context = itemView.getContext();

        public ViewHolder(View itemView) {
            super(itemView);
            trainname = (TextView) itemView.findViewById(R.id.trainnametv);
            trainnumbertextview = (TextView) itemView.findViewById(R.id.trainnumbertv);
            rootNumberTv = (TextView)itemView.findViewById(R.id.root_number_tv);
            scheduleDeparture = (TextView)itemView.findViewById(R.id.schedule_departure_tv);
            scheduleArrival = (TextView) itemView.findViewById(R.id.schedule_arr_tv);
            distance = (TextView) itemView.findViewById(R.id.distance_tv);
            stationname = (TextView) itemView.findViewById(R.id.station_name_tv);
            halt = (TextView) itemView.findViewById(R.id.halt_time_tv);
        }
    }
}
