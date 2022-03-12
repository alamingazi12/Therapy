package com.example.therapyspace.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.therapyspace.R;
import com.example.therapyspace.model.Message;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import static com.example.therapyspace.R.drawable.filter;
import static com.example.therapyspace.R.drawable.layout_style_bg;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {
    public MessageAdapter(Context context, ArrayList<Message> messageslist) {
        this.context = context;
        this.messageslist = messageslist;
    }

     Context context;
     ArrayList<Message> messageslist;
    @NonNull
    @NotNull
    @Override
    public MessageAdapter.MessageViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.notification_item_layout,parent,false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MessageAdapter.MessageViewHolder holder, int position) {
           Message message=messageslist.get(position);
           holder.messge_time.setText(message.getMessage_time());
           holder.msg_title.setText(message.getMessage_title());
           holder.subtitle.setText(message.getSub_title());
           if(position==3){
               holder.msg_layout.setBackgroundColor(Color.parseColor("#E3E3E3"));
               holder.image_delete.setVisibility(View.VISIBLE);
               holder.msg_layout.setBackground(context.getDrawable(layout_style_bg));
              // holder.msg_layout.setBackground(context.getDrawable(layout_style_bg));
           }

    }

    @Override
    public int getItemCount() {
        return messageslist.size();
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {

        TextView messge_time,msg_title,subtitle;
        ConstraintLayout msg_layout;
        ImageView image_delete;
        public MessageViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            msg_layout=itemView.findViewById(R.id.message_layout);
            messge_time=itemView.findViewById(R.id.msg_time);
            msg_title=itemView.findViewById(R.id.msg_title);
            subtitle=itemView.findViewById(R.id.msg_subtitle);
            image_delete=itemView.findViewById(R.id.delete_image);
        }
    }
}
