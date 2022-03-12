package com.example.therapyspace.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.therapyspace.R;
import com.example.therapyspace.model.Billing;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class BillingAdapter extends RecyclerView.Adapter<BillingAdapter.BillingViewHolder> {
    public BillingAdapter(Context context, ArrayList<Billing> billingslist) {
        this.context = context;
        this.billingslist = billingslist;
    }

    Context context;
    ArrayList<Billing> billingslist;

    @NonNull
    @NotNull
    @Override
    public BillingViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_billing_detalils,parent,false);
        return  new BillingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull BillingViewHolder holder, int position) {
               Billing billing_item= billingslist.get(position);
               holder.billing_titile.setText(billing_item.getBilling_title());
               holder.billing_subtitle.setText(billing_item.getBilling_Sub_title());
               holder.billing_amaount.setText(""+billing_item.getBilling_amount());
    }

    @Override
    public int getItemCount() {
        return billingslist.size();
    }

    public class BillingViewHolder extends RecyclerView.ViewHolder {
        TextView billing_titile,billing_subtitle,billing_amaount;
        public BillingViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            billing_subtitle=itemView.findViewById(R.id.bill_sub_title);
            billing_titile=itemView.findViewById(R.id.billing_title);
            billing_amaount=itemView.findViewById(R.id.billing_amount);
        }
    }
}
