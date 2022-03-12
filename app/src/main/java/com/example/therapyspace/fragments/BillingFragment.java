package com.example.therapyspace.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.therapyspace.R;
import com.example.therapyspace.adapter.BillingAdapter;
import com.example.therapyspace.model.Billing;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BillingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BillingFragment extends Fragment {
   ArrayList<Billing> billingslist;
    RecyclerView billing_info_container;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BillingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BillingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BillingFragment newInstance(String param1, String param2) {
        BillingFragment fragment = new BillingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_billing, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        intAll(view);
    }

    private void intAll(View view) {
        billingslist=new ArrayList<>();
        billingslist.add(new Billing("Adam Steveson","Wed 17 Oct, 2020",85))  ;
        billingslist.add(new Billing("Erik Obendorf","Wed 17 Oct, 2020",65))  ;
        billingslist.add(new Billing("Sophie Smith","Wed 17 Oct, 2020",60))  ;
        billing_info_container=view.findViewById(R.id.bill_container);
        billing_info_container.setHasFixedSize(true);
        billing_info_container.setLayoutManager(new LinearLayoutManager(getContext()));
        BillingAdapter adapter=new BillingAdapter(getContext(),billingslist);
        billing_info_container.setAdapter(adapter);
    }
}