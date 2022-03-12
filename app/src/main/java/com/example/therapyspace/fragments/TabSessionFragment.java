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
import com.example.therapyspace.adapter.SessionAdapter;
import com.example.therapyspace.model.Sessions;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TabSessionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TabSessionFragment extends Fragment {
     RecyclerView session_container;
     ArrayList<Sessions> sessionsList;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TabSessionFragment() {
        // Required empty public constructor
    }


    public static TabSessionFragment newInstance(String param1, String param2) {
        TabSessionFragment fragment = new TabSessionFragment();
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
        return inflater.inflate(R.layout.fragment_tab_session, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initAll(view);
    }

    private void initAll(View view) {
        sessionsList=new ArrayList<>();
        sessionsList.add(new Sessions("Adam Steveson","19 Jan 2019 | 19:30","Video Call","10.00-12.00 pm"));
        sessionsList.add(new Sessions("Adam Steveson","19 Jan 2019 | 19:30","Video Call","10.00-12.00 pm"));
        sessionsList.add(new Sessions("Adam Steveson","19 Jan 2019 | 19:30","Video Call","10.00-12.00 pm"));
        sessionsList.add(new Sessions("Adam Steveson","19 Jan 2019 | 19:30","Video Call","10.00-12.00 pm"));

        session_container=view.findViewById(R.id.tab_session_container);
        session_container.setHasFixedSize(true);
        session_container.setLayoutManager(new LinearLayoutManager(getContext()));
        SessionAdapter sessionAdapter=new SessionAdapter(getActivity(),sessionsList,2);
        session_container.setAdapter(sessionAdapter);
    }
}