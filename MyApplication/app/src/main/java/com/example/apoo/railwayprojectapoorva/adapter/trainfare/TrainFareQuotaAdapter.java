package com.example.apoo.railwayprojectapoorva.adapter.trainfare;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.apoo.railwayprojectapoorva.R;
import com.example.apoo.railwayprojectapoorva.entities.trainfare.TrainFare;

import java.util.List;

/**
 * Created by Apoo on 6/11/2017.
 */

public class TrainFareQuotaAdapter extends RecyclerView.Adapter<TrainFareQuotaAdapter.ViewHolder>  {

    Context context;
    List<TrainFare> fareList;

    //constructor
    public TrainFareQuotaAdapter(List<TrainFare> fareList, Context context) {
        this.context = context;
        this.fareList = fareList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_row_item_recycler_train_fare,parent,false);

        TrainFareQuotaAdapter.ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.textViewQuotaname.setText(fareList.get(position).getName());
        holder.textViewfarevalue.setText(fareList.get(position).getFare());
        holder.textViewquotacode.setText(fareList.get(position).getCode());

    }

    @Override
    public int getItemCount() {
        return fareList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewQuotaname;
        TextView textViewquotacode;
        TextView textViewfarevalue;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewQuotaname = (TextView) itemView.findViewById(R.id.quota_name_tv);
            textViewquotacode = (TextView) itemView.findViewById(R.id.quotacodetv);
            textViewfarevalue = (TextView) itemView.findViewById(R.id.faretextview);
        }
    }

}
