package com.example.tictoctoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.LinearLayout;

public class LayoutHolderActivity extends AppCompatActivity {
     LinearLayout homeLayout ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_holder_activity);

        homeLayout = findViewById(R.id.homeLayout);
        HomeFragment fragment = new HomeFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.homeLayout,fragment);
        transaction.commit();

    }
}