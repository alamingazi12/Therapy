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
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.therapyspace.R;
import com.example.therapyspace.adapter.DocumentAdapter;
import com.example.therapyspace.adapter.NoteAdapter;
import com.example.therapyspace.model.Document;
import com.example.therapyspace.model.Note;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NoteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NoteFragment extends Fragment {
     ImageView note_menu_btn;
      RecyclerView note_item_container;
      ArrayList<Note> user_note_list;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NoteFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NoteFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NoteFragment newInstance(String param1, String param2) {
        NoteFragment fragment = new NoteFragment();
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
        return inflater.inflate(R.layout.fragment_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initAll(view);
        note_item_container=view.findViewById(R.id.note_container);
        initList();
    }

    private void initAll(View view) {
        note_menu_btn=view.findViewById(R.id.note_menu_btn);
        note_menu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PopupMenu popup=new PopupMenu(getContext(),note_menu_btn);
                //inflating menu from xml resource
                  popup.inflate(R.menu.note_menu);
                //Menu menu=   popup.getMenu();

                //adding click listener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(android.view.MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.call_client:
                                Toast.makeText(getContext(),"menu item Clicked",Toast.LENGTH_SHORT).show();
                               // Essentials.logout(MainActivity.this);
                                break;
                            case R.id.video_call_client:
                                Toast.makeText(getContext(),"menu item Clicked",Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;
                    }
                });
                popup.show();
            }
        });
    }

    private void initList() {
        note_item_container.setHasFixedSize(true);
        note_item_container.setLayoutManager(new LinearLayoutManager(getContext()));
        user_note_list=new ArrayList<>();
        user_note_list.add(new Note("Client notes","Lorem ipsum dolor sit amet.","2 Jan 2019",R.drawable.small_doc,0));
        user_note_list.add(new Note("Client notes","Lorem ipsum dolor sit amet.","2 Jan 2019",R.drawable.small_doc,R.drawable.note_item_image));
        NoteAdapter noteAdapter=new NoteAdapter(user_note_list,getContext());
        note_item_container.setAdapter(noteAdapter);

    }
}