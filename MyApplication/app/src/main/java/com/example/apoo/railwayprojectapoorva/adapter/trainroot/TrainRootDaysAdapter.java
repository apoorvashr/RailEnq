package com.example.apoo.railwayprojectapoorva.adapter.trainroot;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.apoo.railwayprojectapoorva.R;
import com.example.apoo.railwayprojectapoorva.entities.root.RootClasses;

import java.util.ArrayList;

/**
 * Created by Apoo on 7/14/2017.
 */

public class TrainRootDaysAdapter extends RecyclerView.Adapter<TrainRootDaysAdapter.ViewHolder> {

    private Context context;
    ArrayList<RootClasses> fillsingleRow2;

    //constructor
    public TrainRootDaysAdapter(Context context/*, ArrayList<RootClasses> fillsingleRow2*/) {
    /*    this.fillsingleRow2 = fillsingleRow2;*/
        this.context = context;
    }


    @Override
    public TrainRootDaysAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_row_item_train_root_classes_activity,parent,false);

        TrainRootDaysAdapter.ViewHolder vh = new TrainRootDaysAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(TrainRootDaysAdapter.ViewHolder holder, int position) {

     /*   holder.classcode.setText(fillsingleRow2.get(position).getClasscode());
        holder.availability.setText(fillsingleRow2.get(position).getAvailablity());
*/
    }

    @Override
    public int getItemCount() {
        return fillsingleRow2.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView classcode;
        TextView availability;

        final Context context = itemView.getContext();

        public ViewHolder(View itemView) {
            super(itemView);
           /* classcode = (TextView) itemView.findViewById(R.id.Class_code_tv);
            availability = (TextView) itemView.findViewById(R.id.trainnumbertv);
       */ }
    }
}
