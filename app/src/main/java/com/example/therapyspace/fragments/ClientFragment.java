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
import com.example.therapyspace.adapter.ClientAdapter;
import com.example.therapyspace.model.Client;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ClientFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ClientFragment extends Fragment {
      ArrayList<Client> clientlist;

    RecyclerView recyclerView_client_container;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ClientFragment() {
        // Required empty public constructor
    }

    public static ClientFragment newInstance(String param1, String param2) {
        ClientFragment fragment = new ClientFragment();
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
        return inflater.inflate(R.layout.fragment_client, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initClientlist();
        initAll(view);
    }

    private void initClientlist() {
        clientlist=new ArrayList<>();
        clientlist.add(new Client("A","Adam Steveson","No bookings"));
        clientlist.add(new Client("A","Adam Steveson","2nd of July @ 19:20"));
        clientlist.add(new Client("A","Erik Anderson","No bookings"));
        clientlist.add(new Client("A","Erin Loukia","No bookings"));

        clientlist.add(new Client("C","Adam Steveson","No bookings"));
        clientlist.add(new Client("C","Adam Steveson","2nd of July @ 19:20"));
        clientlist.add(new Client("C","Erik Anderson","No bookings"));
        clientlist.add(new Client("C","Erin Loukia","No bookings"));

        clientlist.add(new Client("D","Adam Steveson","No bookings"));
        clientlist.add(new Client("D","Adam Steveson","2nd of July @ 19:20"));
        clientlist.add(new Client("D","Erik Anderson","No bookings"));
        clientlist.add(new Client("D","Erin Loukia","No bookings"));
    }

    private void initAll(View view) {
        recyclerView_client_container=view.findViewById(R.id.client_containerview);
        recyclerView_client_container.setHasFixedSize(true);
        recyclerView_client_container.setLayoutManager(new LinearLayoutManager(getContext()));
        ClientAdapter clientAdapter=new ClientAdapter(clientlist,getContext());
        recyclerView_client_container.setAdapter(clientAdapter);
    }
}