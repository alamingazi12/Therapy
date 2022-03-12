package com.example.therapyspace.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.therapyspace.MenuActivity;
import com.example.therapyspace.NoteActivity;
import com.example.therapyspace.PlaceAdapter;
import com.example.therapyspace.PractionerHomeActivity;
import com.example.therapyspace.R;
import com.example.therapyspace.adapter.SessionAdapter;
import com.example.therapyspace.model.Place;
import com.example.therapyspace.model.Sessions;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    NavController navController;
    ArrayList<Sessions> sessionsList;
    ImageView image_go_to_session;
    ArrayList<Place> placeList;

    RecyclerView session_container,place_container;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {

        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initArrayList();
        initAll(view);
        view.findViewById(R.id.img_go_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), MenuActivity.class);
                startActivity(intent);
            }
        });
        image_go_to_session=view.findViewById(R.id.go_all_session);
        image_go_to_session.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.home_to_session);
            }
        });
    }

    private void initArrayList() {
        sessionsList=new ArrayList<>();
        sessionsList.add(new Sessions("Adam Steveson","Video Call","10.00-12.00 pm"));
        sessionsList.add(new Sessions("Adam Steveson","Video Call","10.00-12.00 pm"));
        sessionsList.add(new Sessions("Adam Steveson","Video Call","10.00-12.00 pm"));



    }

    private void initAll(View view) {

        session_container=view.findViewById(R.id.session_container);
        session_container.setHasFixedSize(true);
        session_container.setLayoutManager(new LinearLayoutManager(getContext()));
        SessionAdapter sessionAdapter=new SessionAdapter(getActivity(),sessionsList,1);
        session_container.setAdapter(sessionAdapter);


        placeList=new ArrayList<>();
        placeList.add(new Place("Dhaka Mohakhali","Video Call,audio call","10.00-12.00 pm"));
        placeList.add(new Place("Khulna shib bari","Video Call,messaging,text","10.00-12.00 pm"));

        place_container=view.findViewById(R.id.place_container);
        place_container.setHasFixedSize(true);
        place_container.setLayoutManager(new LinearLayoutManager(getContext()));
        PlaceAdapter Place_adapter=new PlaceAdapter(getActivity(),placeList);
        place_container.setAdapter(Place_adapter);
    }
}