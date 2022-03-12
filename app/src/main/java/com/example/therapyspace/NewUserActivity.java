package com.example.therapyspace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.therapyspace.adapter.UserAdapter;
import com.example.therapyspace.model.Feature;

import java.util.ArrayList;

public class NewUserActivity extends AppCompatActivity {
   ArrayList<Feature> featureslist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        initAll();
        findViewById(R.id.go_notification).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(NewUserActivity.this,NotificationActivity
                        .class);
                startActivity(intent);
            }
        });
    }

    private void initAll() {
        featureslist=new ArrayList<>();
        featureslist.add(new Feature(01,"Select payment plan",R.drawable.mark_ok));
        featureslist.add(new Feature(02,"Setup your profile",R.drawable.mark_ok));
        featureslist.add(new Feature(03,"Setup your weekly schedule",R.drawable.mark_ok));
        featureslist.add(new Feature(04,"Invite your clients",R.drawable.mark_ok));
        featureslist.add(new Feature(05,"Setup a session",R.drawable.mark_ok));

        RecyclerView recyclerView_feature=findViewById(R.id.feature_container);
        recyclerView_feature.setHasFixedSize(true);
        recyclerView_feature.setLayoutManager(new LinearLayoutManager(this));
        UserAdapter userAdapter=new UserAdapter(featureslist,NewUserActivity.this);
        recyclerView_feature.setAdapter(userAdapter);

    }
}