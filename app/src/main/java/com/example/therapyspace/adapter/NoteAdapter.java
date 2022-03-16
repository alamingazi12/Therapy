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
import com.example.therapyspace.model.Note;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {
    public NoteAdapter(ArrayList<Note> user_note_list, Context context) {
        this.user_note_list = user_note_list;
        this.context = context;
    }

    ArrayList<Note> user_note_list;
    Context context;
    @NonNull
    @NotNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.note_item,parent,false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull NoteViewHolder holder, int position) {
                Note note=user_note_list.get(position);
                holder.note_title.setText(note.getTitle());
                holder.note_details.setText(note.getDesc());
                holder.note_date.setText(note.getDate());
                holder.note_small_item_image.setImageResource(note.getNote_image());
                if(note.getBig_image()!=0){
                    holder.item_big_image.setVisibility(View.VISIBLE);
                    holder.item_big_image.setImageResource(note.getBig_image());
                }

    }

    @Override
    public int getItemCount() {
        return user_note_list.size();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {

        TextView note_title,note_details,note_date;
        ImageView note_small_item_image,item_big_image;
        public NoteViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            note_title=itemView.findViewById(R.id.note_title);
            note_details=itemView.findViewById(R.id.note_desc);
            note_date=itemView.findViewById(R.id.note_date);
            note_small_item_image=itemView.findViewById(R.id.note_icon_image);
            item_big_image=itemView.findViewById(R.id.note_item_image);

        }
    }
}
