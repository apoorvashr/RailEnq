package com.example.apoo.railwayprojectapoorva.adapter.livetrain;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.apoo.railwayprojectapoorva.R;
import com.example.apoo.railwayprojectapoorva.entities.live.Live;
import com.example.apoo.railwayprojectapoorva.entities.root.Root;
import com.example.apoo.railwayprojectapoorva.entities.root.RootClasses;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Apoo on 6/15/2017.
 */

public class TrainLiveAdapter extends RecyclerView.Adapter<TrainLiveAdapter.ViewHolder> {

    private Context context;
    ArrayList<Live> fillsingleRow;


    //constructor
    public TrainLiveAdapter(Context context, ArrayList<Live> fillsingleRow) {
        this.fillsingleRow = fillsingleRow;
        this.context = context;
    }


    @Override
    public TrainLiveAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_row_item_train_live,parent,false);

        TrainLiveAdapter.ViewHolder vh = new TrainLiveAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(TrainLiveAdapter.ViewHolder holder, int position) {

        holder.stationnName.setText(fillsingleRow.get(position).getStationName());
        holder.stationNumber.setText(fillsingleRow.get(position).getStationNumber());
        holder. scheduleDeparture.setText(fillsingleRow.get(position).getScheduleDeparture());
        holder.scheduleArrival.setText(fillsingleRow.get(position).getScheduleArrival());
        holder.actualDeparture.setText(fillsingleRow.get(position).getActualDeparture());
        holder.actualArrival.setText(fillsingleRow.get(position).getActualArrival());
        holder.lateByMinuteStatus.setText(fillsingleRow.get(position).getStatusLateByMinute());
        holder.runningDay.setText(fillsingleRow.get(position).getDay());
        holder.hasDeparturedFromHere.setText(fillsingleRow.get(position).getHasDepartedFromHere());
        holder.hasArrivedHere.setText(fillsingleRow.get(position).getHasArrivedHere());
        holder.distance.setText(fillsingleRow.get(position).getDistanceFromSource());
        holder.scheduleArrivalDate.setText(fillsingleRow.get(position).getScheduleArrivalDate());
        holder.actualArrivalDate.setText(fillsingleRow.get(position).getActualArrivalDate());

    }

    @Override
    public int getItemCount() {
        return fillsingleRow.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView stationnName;
        TextView stationNumber;
        TextView scheduleDeparture,scheduleArrival;
        TextView actualDeparture,actualArrival;
        TextView scheduleArrivalDate,actualArrivalDate;
        TextView lateByMinuteStatus;
        TextView runningDay;
        TextView hasDeparturedFromHere,hasArrivedHere;
        TextView distance;


        public ViewHolder(View itemView) {
            super(itemView);
            stationnName = (TextView) itemView.findViewById(R.id.stationnametv);
            stationNumber = (TextView) itemView.findViewById(R.id.station_number_in_path_tv);
            hasArrivedHere = (TextView) itemView.findViewById(R.id.live_arrived_at_station_tv);
            hasDeparturedFromHere = (TextView) itemView.findViewById(R.id.has_departed_from_this_station_tv);
            scheduleDeparture = (TextView)itemView.findViewById(R.id.live_schedule_departure_tv);
            scheduleArrival = (TextView) itemView.findViewById(R.id.live_schedule_arrive_tv);
            actualDeparture = (TextView)itemView.findViewById(R.id.live_actual_departure_tv);
            actualArrival = (TextView) itemView.findViewById(R.id.live_act_arr_tv);
            scheduleArrivalDate = (TextView) itemView.findViewById(R.id.schedule_arrival_date_tv);
            actualArrivalDate = (TextView) itemView.findViewById(R.id.actual_arrival_date_tv);
            lateByMinuteStatus = (TextView) itemView.findViewById(R.id.late_by_minute_status_tv);
            runningDay = (TextView) itemView.findViewById(R.id.travelling_day_tv);
            distance = (TextView) itemView.findViewById(R.id.distance_from_source_station_tv);
        }
    }
}
