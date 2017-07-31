/*
 * Copyright (C) 2015 Thomas Robert Altstidl
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.apoo.railwayprojectapoorva.adapter.trainarrivaladap;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.apoo.railwayprojectapoorva.R;
import com.example.apoo.railwayprojectapoorva.entities.trainarrivalatstation.TrainArrival;
import com.example.apoo.railwayprojectapoorva.view.trainarrivalsatsta.TrainarrivalatstationDetailActivity;
import com.tr4android.recyclerviewslideitem.SwipeAdapter;
import com.tr4android.recyclerviewslideitem.SwipeConfiguration;

import java.util.List;

public class SampleAdapter extends SwipeAdapter implements View.OnClickListener {
     List<TrainArrival> fareList;
    private Context mContext;
    private RecyclerView mRecyclerView;


    //constructor
    public SampleAdapter(Context context, RecyclerView recyclerView,List<TrainArrival> fareList) {
        mContext = context;
        mRecyclerView = recyclerView;
        this.fareList = fareList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateSwipeViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_row_item_train_arrival_activity, parent, true);
        return new SampleViewHolder(v);
    }

    @Override
    public void onBindSwipeViewHolder(RecyclerView.ViewHolder swipeViewHolder, int i) {
        SampleViewHolder sampleViewHolder = (SampleViewHolder) swipeViewHolder;
        sampleViewHolder.textViewtrainname.setText(fareList.get(i).getTrainName());
        sampleViewHolder.trainnumber.setText(fareList.get(i).getTrainNumber());
    }

    @Override
    public SwipeConfiguration onCreateSwipeConfiguration(Context context, int position) {
        return new SwipeConfiguration.Builder(context)
                .setLeftBackgroundColorResource(R.color.primary_light)
                .setDrawableResource(R.mipmap.ic_bank_icon_finder)
                .setLeftUndoDescription("navigate to Details")
                .setUndoable(true)
                .setRightUndoable(true)
                .setLeftSwipeBehaviour(SwipeConfiguration.SwipeBehaviour.NORMAL_SWIPE)
                .setLeftUndoable(true)
                .setRightSwipeBehaviour(SwipeConfiguration.SwipeBehaviour.NORMAL_SWIPE)
                .build();
    }

    @Override
    public void onSwipe(int position, int direction) {
        if (direction == SWIPE_LEFT) {
            //  Log.d("---", "onSwipe: "+"getting the child position here"+fareList.get(mRecyclerView.getChildAdapterPosition((View) view.getParent().getParent())).getTrainNumber());
            Log.d("", "onSwipe: " + "-----" + fareList.get(position).getTrainNumber().toString());


            Intent intent = new Intent(mContext, TrainarrivalatstationDetailActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            intent.putExtra("parameter1", fareList.get(position).getTrainNumber().toString());
            intent.putExtra("parameter2", fareList.get(position).getTrainName().toString());
            intent.putExtra("parameter3", fareList.get(position).getDelay_depature().toString());
            intent.putExtra("parameter4", fareList.get(position).getDelay_arrive().toString());
            intent.putExtra("parameter5", fareList.get(position).getActual_arrive().toString());
            intent.putExtra("parameter6", fareList.get(position).getActual_depature().toString());
            intent.putExtra("parameter7", fareList.get(position).getSch_depature().toString());
            intent.putExtra("parameter8", fareList.get(position).getSch_arrive().toString());
            mContext.startActivity(intent);
        }
    }

    @Override
    public void onClick(View view) {
        // We need to get the parent of the parent to actually have the proper view
       int  positionitem = mRecyclerView.getChildAdapterPosition((View) view.getParent().getParent());
    }

    @Override
    public int getItemCount() {
        return fareList.size();
    }

    //TODO: view holder class

    public class SampleViewHolder extends RecyclerView.ViewHolder {
        LinearLayout contentView;
        View avatarView;
        TextView textViewtrainname,trainnumber;


        public SampleViewHolder(View view) {
            super(view);
            contentView = (LinearLayout) view.findViewById(R.id.linear_container);
            avatarView = view.findViewById(R.id.avatarView);
            textViewtrainname = (TextView) view.findViewById(R.id.train_name_train_Arrival_mod);
            trainnumber = (TextView) view.findViewById(R.id.train_number_train_arrival);
            contentView.setOnClickListener(SampleAdapter.this);
        }


    }

}