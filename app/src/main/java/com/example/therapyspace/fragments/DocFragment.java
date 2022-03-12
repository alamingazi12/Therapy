package com.example.therapyspace.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.therapyspace.R;
import com.example.therapyspace.adapter.DocumentAdapter;
import com.example.therapyspace.model.Document;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DocFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DocFragment extends Fragment {
   RecyclerView document_conteiner;

    ArrayList<Document> documentslist;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DocFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DocFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DocFragment newInstance(String param1, String param2) {
        DocFragment fragment = new DocFragment();
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
    private void initList() {
        documentslist=new ArrayList<>();
        documentslist.add(new Document("CORE-OM","2 Jan 2019"));
        documentslist.add(new Document("CORE-OM","2 Jan 2019"));
        documentslist.add(new Document("CORE-OM","2 Jan 2019"));
        documentslist.add(new Document("CORE-OM","2 Jan 2019"));

        //DocumentAdapter documentAdapter=new DocumentAdapter(documentslist,getActivity());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_doc, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initList();
        initAll(view);
    }

    private void initAll(View view) {
        document_conteiner=view.findViewById(R.id.doc_container);
        document_conteiner.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),2);
        document_conteiner.setLayoutManager(gridLayoutManager);
        DocumentAdapter documentAdapter=new DocumentAdapter(documentslist,getActivity());
        document_conteiner.setAdapter(documentAdapter);
    }
}