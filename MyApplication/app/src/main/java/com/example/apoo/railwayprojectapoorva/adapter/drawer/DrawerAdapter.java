package com.example.apoo.railwayprojectapoorva.adapter.drawer;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.apoo.railwayprojectapoorva.R;
import com.example.apoo.railwayprojectapoorva.entities.drawer.DataModel;
import com.example.apoo.railwayprojectapoorva.view.aboutus.AboutUsActivity;
import com.example.apoo.railwayprojectapoorva.view.info.InfoAct;
import com.example.apoo.railwayprojectapoorva.view.reschedule.RescheEnqAct;

import java.util.ArrayList;

/**
 * Created by Apoo on 6/15/2017.
 */

public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.ViewHolder> {

    private Context context;
    //ArrayList<ParentMenu2> fillsingleRow;
    DataModel data[] = null;


    //constructor
    public DrawerAdapter(Context context, DataModel[] data) {
        this.context = context;
        this.data = data;
    }


    @Override
    public DrawerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_row_item_drawer,parent,false);

        DrawerAdapter.ViewHolder vh = new DrawerAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(DrawerAdapter.ViewHolder holder, final int position) {
        DataModel folder = data[position];

        holder.imageViewIcon.setImageResource(folder.icon);
        holder.titleName.setText(folder.name);
        holder.titleName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();

                if (position ==0)
                {
                    Intent intent = new Intent(context, RescheEnqAct.class);
                    context.startActivity(intent);
                }

                if (position ==1)
                {
                    Intent intent = new Intent(context, RescheEnqAct.class);
                    context.startActivity(intent);
                }

                if (position ==2)
                {
                    Intent intent = new Intent(context, InfoAct.class);
                    context.startActivity(intent);
                }


                if (position ==3)
                {
                    Intent intent = new Intent(context, AboutUsActivity.class);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {

        ImageView imageViewIcon;
        TextView titleName;
        RelativeLayout relativeLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            imageViewIcon = (ImageView) itemView.findViewById(R.id.nav_icon);
            titleName = (TextView) itemView.findViewById(R.id.parentTextView);
           // relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relative_container);

          }

    }
}
