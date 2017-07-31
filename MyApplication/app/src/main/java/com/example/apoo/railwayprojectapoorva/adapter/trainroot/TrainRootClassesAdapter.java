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
import java.util.List;

/**
 * Created by Apoo on 6/15/2017.
 */

public class TrainRootClassesAdapter extends RecyclerView.Adapter<TrainRootClassesAdapter.ViewHolder> {

    private Context context;
    ArrayList<RootClasses> fillsingleRow2 = new ArrayList<RootClasses>();
    RootClasses rootClasses;
    List<String> classdetails;

    //constructor
    public TrainRootClassesAdapter(Context context, RootClasses rootClasses) {
        this.context = context;
        this.rootClasses = rootClasses;
    }


    @Override
    public TrainRootClassesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_row_item_train_root_classes_activity,parent,false);

        TrainRootClassesAdapter.ViewHolder vh = new TrainRootClassesAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(TrainRootClassesAdapter.ViewHolder holder, int position) {


      //  holder.availability.setText(rootClasses.getAvailablity());

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
          /*  classcode = (TextView) itemView.findViewById(R.id.Class_code_tv);
            availability = (TextView) itemView.findViewById(R.id.trainnumbertv);
         */  }
    }
}
