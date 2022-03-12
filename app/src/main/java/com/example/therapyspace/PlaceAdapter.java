package com.example.therapyspace;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.therapyspace.model.Place;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder> {


    public PlaceAdapter(Context context, ArrayList<Place> places) {
        this.context = context;
        this.places = places;
    }

    Context context;
    ArrayList<Place> places;
    @NonNull
    @NotNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
         View view=LayoutInflater.from(context).inflate(R.layout.layout_session_place_item,parent,false);
         return new PlaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull PlaceViewHolder holder, int position) {
        Place place=places.get(position);
        if(place==null){

            Toast.makeText(context,"data null",Toast.LENGTH_SHORT).show();
        }else {
            holder.place_name.setText(place.getName());
            holder.c_type.setText(place.getC_type());
            holder.time.setText(place.getTime());
        }

    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    public class PlaceViewHolder extends RecyclerView.ViewHolder {
        TextView place_name,c_type,time;
        public PlaceViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            place_name=itemView.findViewById(R.id.place_name);
            c_type=itemView.findViewById(R.id.call_type);
            time=itemView.findViewById(R.id.call_time);
        }
    }
}
