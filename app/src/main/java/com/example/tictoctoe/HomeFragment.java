package com.example.tictoctoe;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
        txtMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediumLevelFragment fragment = new MediumLevelFragment();
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.homeLayout,fragment);
                transaction.commit();
            }
        });

        txtHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
                dialog.setIcon(R.drawable.sorry_icon);
                dialog.setTitle("Sorry");
                dialog.setMessage("Your brain is not Capable for this Level !")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.dismiss();
                            }
                        });
                AlertDialog alert = dialog.create();
                alert.show();
            }
        });


        return view;
    }
}