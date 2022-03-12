package com.example.therapyspace.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.therapyspace.R;
import com.example.therapyspace.model.ModelActivity;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ActivitysAdapter extends RecyclerView.Adapter<ActivitysAdapter.ActivitiesViewHolder> {
    public ActivitysAdapter(ArrayList<ModelActivity> activitieslist, Context context) {
        this.activitieslist = activitieslist;
        this.context = context;
    }

    ArrayList<ModelActivity> activitieslist;
      Context context;
    @NonNull
    @NotNull
    @Override
    public ActivitiesViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.activity_item_layout,parent,false);
        return new ActivitiesViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ActivitiesViewHolder holder, int position) {
            ModelActivity modelActivity=activitieslist.get(position);
            holder.date_time.setText(modelActivity.getDate_time());
            holder.title.setText(modelActivity.getTitle());
            holder.action_image.setImageResource(modelActivity.getImage_source());
            if(!modelActivity.getSub_title().equals("")){
                holder.sub_title.setVisibility(View.VISIBLE);
                holder.sub_title.setText(modelActivity.getSub_title());
            }
    }

    @Override
    public int getItemCount() {
        return activitieslist.size();

    }

    public class ActivitiesViewHolder extends RecyclerView.ViewHolder {

        TextView date_time,title,sub_title;
        ImageView action_image;
        public ActivitiesViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            action_image=itemView.findViewById(R.id.activity_image);
            title=itemView.findViewById(R.id.activity_title);
            date_time=itemView.findViewById(R.id.activity_datetime);
            sub_title=itemView.findViewById(R.id.sub_titles);

        }
    }
}
