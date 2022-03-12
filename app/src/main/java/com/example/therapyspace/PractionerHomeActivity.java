package com.example.therapyspace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PractionerHomeActivity extends AppCompatActivity {
  static   NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practioner_home);

         navController= Navigation.findNavController(this,R.id.my_nav_host_fragment);
        // NavigationUI.setupActionBarWithNavController(this,Navigation.findNavController(this,R.id.my_nav_host_fragment));
        BottomNavigationView navigationView=findViewById(R.id.bottom_nav);
        //NavigationUI.setupWithNavController(navigationView, navController);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("ResourceType")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.home:
                        navController.navigate(R.id.home_fragment);
                        break;
                    case R.id.schedule_fragment:
                       navController.navigate(R.id.schedule_fragment);
                        break;
                    case R.id.clients:
                        navController.navigate(R.id.clients_fragment);
                      //  Intent intent2=new Intent(MainActivity.this,ProfileActivity.class);
                       // startActivity(intent2);
                        break;
                }
                return true;
            }
        });
    }
}