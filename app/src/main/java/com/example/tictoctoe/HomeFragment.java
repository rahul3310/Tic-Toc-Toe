package com.example.tictoctoe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HomeFragment extends Fragment {
     TextView txtEasy , txtMedium , txtHard;
     LinearLayout homeLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        txtEasy=view.findViewById(R.id.txtEasy);
        txtMedium=view.findViewById(R.id.txtMedium);
        txtHard=view.findViewById(R.id.txtHard);

        txtEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EasyLevelFragment fragment = new EasyLevelFragment();
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.homeLayout,fragment);
                transaction.commit();
            }
        });




        return view;
    }
}