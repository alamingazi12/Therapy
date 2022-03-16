package com.example.therapyspace;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.therapyspace.fragments.ActivitiesFragment;
import com.example.therapyspace.fragments.DocFragment;
import com.example.therapyspace.fragments.NoteFragment;
import com.example.therapyspace.fragments.TabSessionFragment;
import com.google.android.material.tabs.TabLayout;

import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ClientsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ClientsFragment extends Fragment {
    ImageView client_menu_btn;
    ViewPager view_donation_history;
    TabLayout tabLayout_donation;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ClientsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ClientsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ClientsFragment newInstance(String param1, String param2) {
        ClientsFragment fragment = new ClientsFragment();
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
        return inflater.inflate(R.layout.fragment_clients, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initAll(view);
        view_donation_history=view.findViewById(R.id.client_viewpager);
        SectionsPagerAdapter sectionsPagerAdapter=new SectionsPagerAdapter(getActivity().getSupportFragmentManager());
        view_donation_history.setAdapter(sectionsPagerAdapter);
        tabLayout_donation=view.findViewById(R.id.client_tab);
        tabLayout_donation.setupWithViewPager(view_donation_history);
    }

    private void initAll(View view) {
        client_menu_btn=view.findViewById(R.id.client_menu_btn);
        client_menu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PopupMenu popup=new PopupMenu(getContext(),client_menu_btn);
                //inflating menu from xml resource
                popup.inflate(R.menu.client_option_menu);
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
                            case R.id.m_client:
                                Toast.makeText(getContext(),"menu item Clicked",Toast.LENGTH_SHORT).show();
                                // Essentials.logout(MainActivity.this);
                                break;
                            case R.id.del_client:
                                Toast.makeText(getContext(),"menu item Clicked",Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.view_client:
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

    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }



        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = new TabSessionFragment();
                    break;
                case 1:
                    fragment = new NoteFragment();
                    break;
                case 2:
                    fragment = new DocFragment();
                    break;
                case 3:
                    fragment = new ActivitiesFragment();
                    break;
            }
            return fragment;
        }
        @Override
        public int getCount() {
            // Show 4 total pages.
            return 4;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SESSIONS";

                case 1:
                    return "NOTE";
                case 2:
                    return "DOCS";

                case 3:
                    return "ACTIVITY";
            }
            return null;
        }
    }
}