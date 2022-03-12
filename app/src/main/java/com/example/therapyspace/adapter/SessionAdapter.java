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
import com.example.therapyspace.model.Sessions;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class SessionAdapter extends RecyclerView.Adapter<SessionAdapter.SessionViewHolder> {
    ArrayList<Sessions> sessionslist;
    int token;

    public SessionAdapter( Context context,ArrayList<Sessions> sessionslist,int token) {
        this.sessionslist = sessionslist;
        this.context = context;
        this.token=token;
    }

    Context context;

    @NonNull
    @NotNull
    @Override
    public SessionAdapter.SessionViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.session_item_layout,parent,false);
        return new SessionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull SessionAdapter.SessionViewHolder holder, int position) {
        Sessions sessions=sessionslist.get(position);
          if(token==2){
              holder.session_image.setVisibility(View.GONE);
              holder.name.setVisibility(View.GONE);
              holder.call_type.setText(sessions.getC_type());
              holder.time.setText(sessions.getTime());
              holder.sesseion_date.setVisibility(View.VISIBLE);
              holder.sesseion_date.setText(sessions.getDate_time());
          }
          else{
              holder.name.setText(sessions.getName());
              holder.call_type.setText(sessions.getC_type());
              holder.time.setText(sessions.getTime());
          }

           
    }

    @Override
    public int getItemCount() {
        return sessionslist.size();
    }

    public class SessionViewHolder extends RecyclerView.ViewHolder {
        TextView name,call_type,time,sesseion_date;
        ImageView session_image;
        public SessionViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
             session_image=itemView.findViewById(R.id.session_image);
             name= itemView.findViewById(R.id.name);
             call_type=itemView.findViewById(R.id.c_type);
             time=itemView.findViewById(R.id.c_time);
             sesseion_date=itemView.findViewById(R.id.session_dt_time);
        }
    }
}
