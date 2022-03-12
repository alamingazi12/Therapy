package com.example.therapyspace.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.therapyspace.R;
import com.example.therapyspace.model.Feature;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class UserAdapter  extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    public UserAdapter(ArrayList<Feature> featureslist, Context context) {
        this.featureslist = featureslist;
        this.context = context;
    }

    ArrayList<Feature> featureslist;
    Context context;
    @NonNull
    @NotNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.user_item,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull UserViewHolder holder, int position) {
            Feature feature=featureslist.get(position);
            holder.feature.setText(feature.getFeature());
            holder.number.setText(""+feature.getNumber());
            if(feature.getNumber()==2 || feature.getNumber()==3) {
                holder.feature.setTextColor(Color.parseColor("#AEAEAE"));
                holder.icon_go.setImageResource(feature.getRes_id());
            }
    }

    @Override
    public int getItemCount() {
        return featureslist.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        TextView number,feature;
        ImageView icon_go;
        public UserViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            number=itemView.findViewById(R.id.number);
            feature=itemView.findViewById(R.id.user_feature);
            icon_go=itemView.findViewById(R.id.action_img);


        }
    }
}
