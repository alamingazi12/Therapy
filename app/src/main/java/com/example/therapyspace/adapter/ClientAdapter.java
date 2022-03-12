package com.example.therapyspace.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.therapyspace.R;
import com.example.therapyspace.model.Client;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ClientAdapter extends RecyclerView.Adapter<ClientAdapter.ClientViewHolder> {

    public ClientAdapter(ArrayList<Client> clientlist, Context context) {
        this.clientlist = clientlist;
        this.context = context;
    }

    ArrayList<Client> clientlist;
    Context context;
    @NonNull
    @NotNull
    @Override
    public ClientViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(context).inflate(R.layout.client_item_layout,parent,false);
       return  new ClientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ClientViewHolder holder, int position) {
         Client client=clientlist.get(position);
         holder.cl_name.setText(client.getClient_name());
         holder.schedule_time.setText(client.getBooking_date());
         holder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Bundle bundle=new Bundle();
                 bundle.putParcelable("client_object",client);
                 //Toast.makeText(context,"position is:"+position,Toast.LENGTH_SHORT).show();
                 Navigation.findNavController(view).navigate(R.id.client_to_clients_fragment,bundle);
             }
         });
    }

    @Override
    public int getItemCount() {
        return clientlist.size();
    }

    public class ClientViewHolder extends RecyclerView.ViewHolder {
        TextView cl_name,schedule_time;
        public ClientViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            cl_name=itemView.findViewById(R.id.cl_name);
            schedule_time=itemView.findViewById(R.id.schedule_time);
        }
    }
}
