package com.example.therapyspace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.therapyspace.adapter.MessageAdapter;
import com.example.therapyspace.model.Message;

import java.util.ArrayList;

public class NotificationActivity extends AppCompatActivity {

    RecyclerView recyclerView_message_container;
    ArrayList<Message> messagelist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        initArrayList();
        findViewById(R.id.payment_plan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(NotificationActivity.this,PaymentActivity
                        .class);
                startActivity(intent);
            }
        });
    }

    private void initArrayList() {
        messagelist=new ArrayList<>();
        messagelist.add(new Message("2 min age","David Smith has accepted your session","Session time: December 29, 2020"));
        messagelist.add(new Message("2 min age","David Smith has accepted your session","Session time: December 29, 2020"));
        messagelist.add(new Message("2 min age","David Smith has accepted your session","Session time: December 29, 2020"));
        messagelist.add(new Message("2 min age","David Smith has accepted your session","Session time: December 29, 2020"));
        messagelist.add(new Message("2 min age","David Smith has accepted your session","Session time: December 29, 2020"));

        recyclerView_message_container=findViewById(R.id.message_conteiner);
        recyclerView_message_container.setHasFixedSize(true);
        recyclerView_message_container.setLayoutManager(new LinearLayoutManager(this));
        MessageAdapter messageAdapter=new MessageAdapter(NotificationActivity.this,messagelist);
        recyclerView_message_container.setAdapter(messageAdapter);
    }
}