package com.example.therapyspace.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.therapyspace.R;
import com.example.therapyspace.model.Document;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class DocumentAdapter extends RecyclerView.Adapter<DocumentAdapter.DocumentViewHolder> {

    public DocumentAdapter(ArrayList<Document> documentlist, Context context) {
        this.documentlist = documentlist;
        this.context = context;
    }

    ArrayList<Document> documentlist;
    Context context;
    @NonNull
    @NotNull
    @Override
    public DocumentViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.document_item,parent,false);
        return new DocumentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull DocumentViewHolder holder, int position) {
               Document documents=documentlist.get(position);
               holder.doc_name.setText(documents.getDoc_name());
               holder.date.setText(documents.getDoc_date());
    }

    @Override
    public int getItemCount() {
        return documentlist.size();
    }

    public class DocumentViewHolder extends RecyclerView.ViewHolder {
        TextView doc_name,date;
        public DocumentViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            doc_name=itemView.findViewById(R.id.doc_name);
            date=itemView.findViewById(R.id.doc_date);
        }
    }
}
