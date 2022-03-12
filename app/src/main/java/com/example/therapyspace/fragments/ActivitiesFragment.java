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
import com.example.therapyspace.adapter.ActivitysAdapter;
import com.example.therapyspace.model.ModelActivity;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ActivitiesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ActivitiesFragment extends Fragment {
        ArrayList<ModelActivity> activitieslist;
        RecyclerView activities_container;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ActivitiesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ActivitiesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ActivitiesFragment newInstance(String param1, String param2) {
        ActivitiesFragment fragment = new ActivitiesFragment();
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
        return inflater.inflate(R.layout.fragment_activities, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initList(view);

    }

    private void initList(View view) {
        activitieslist=new ArrayList<>();
        activitieslist.add(new ModelActivity("Chat","19 Jan 2019 | 19:30","",R.drawable.ic__call_24));
        activitieslist.add(new ModelActivity("Call","19 Jan 2019 | 19:30","",R.drawable.small_doc));
        activitieslist.add(new ModelActivity("Shared document","19 Jan 2019 | 19:30","",R.drawable.comments));
        activitieslist.add(new ModelActivity("Call","19 Jan 2019 | 19:30","Called to cancel",R.drawable.ic__call_24));
        activities_container=view.findViewById(R.id.all_activities_container);
        activities_container.setHasFixedSize(true);
        activities_container.setLayoutManager(new LinearLayoutManager(getContext()));
        ActivitysAdapter adapter=new ActivitysAdapter(activitieslist,getContext());
        activities_container.setAdapter(adapter);

            }
}