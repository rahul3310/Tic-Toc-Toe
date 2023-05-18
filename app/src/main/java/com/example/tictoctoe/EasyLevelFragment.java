package com.example.tictoctoe;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class EasyLevelFragment extends Fragment implements View.OnClickListener {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,reset;
    ImageView backBtnImg ;
    String b1, b2, b3, b4, b5, b6, b7, b8, b9;
    TextView txtResult;
    int count = 0;
    int winner = 0;
    int flag = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_easy_level, container, false);
        find(view);

       reset.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               btn1.setText("");
               btn2.setText("");
               btn3.setText("");
               btn4.setText("");
               btn5.setText("");
               btn6.setText("");
               btn7.setText("");
               btn8.setText("");
               btn9.setText("");
               flag=0;
               count=0;
               txtResult.setText("");
               ResetColor(btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9);
               DisableButton(true);
           }
       });
       backBtnImg.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
               dialog.setTitle("Exit Game");
               dialog.setIcon(R.drawable.baseline_exit_to_app_24);
               dialog.setMessage("Are you sure you want to Exit?");
               dialog.setCancelable(false);
               dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       HomeFragment fragment = new HomeFragment();
                       FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                       transaction.replace(R.id.homeLayout,fragment);
                       transaction.commit();
                   }
               });

               dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       dialog.dismiss();
                   }
               });
                dialog.show();

           }
       });

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OnBackPressedCallback backPressedCallback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
                dialog.setTitle("Exit Game");
                dialog.setIcon(R.drawable.baseline_exit_to_app_24);
                dialog.setMessage("Are you sure you want to Exit?");
                dialog.setCancelable(false);
                dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        HomeFragment fragment = new HomeFragment();
                        FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.homeLayout, fragment);
                        transaction.commit();
                    }
                });

                dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dialog.show();

            }
        };
        getActivity().getOnBackPressedDispatcher().addCallback(this,backPressedCallback);
    }

    private void find(View view) {
        btn1 = view.findViewById(R.id.btn1);
        btn2 = view.findViewById(R.id.btn2);
        btn3 = view.findViewById(R.id.btn3);
        btn4 = view.findViewById(R.id.btn4);
        btn5 = view.findViewById(R.id.btn5);
        btn6 = view.findViewById(R.id.btn6);
        btn7 = view.findViewById(R.id.btn7);
        btn8 = view.findViewById(R.id.btn8);
        btn9 = view.findViewById(R.id.btn9);
        reset = view.findViewById(R.id.reset);
        backBtnImg = view.findViewById(R.id.backBtn);
        txtResult = view.findViewById(R.id.txtResult);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);


    }

    //implements all buttonClicks inside this function
    public void onClick(View view) {
        Button btnCur = (Button) view;

        if (btnCur.getText().toString().equals("")) {
            count++;
            if (flag == 0) {
                btnCur.setText("X");
                flag = 1;

            } else {
                btnCur.setText("O");
                flag = 0;

            }

        }
        if(count>4){
            b1 = btn1.getText().toString();
            b2 = btn2.getText().toString();
            b3 = btn3.getText().toString();
            b4 = btn4.getText().toString();
            b5 = btn5.getText().toString();
            b6 = btn6.getText().toString();
            b7 = btn7.getText().toString();
            b8 = btn8.getText().toString();
            b9 = btn9.getText().toString();

            //conditions
            if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {
                //1
                changeColor(btn1,btn2,btn3);
                txtResult.setText("Winner!");
                DisableButton(false);
                ResetAfterDelay(2000);
            } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
                //2
                changeColor(btn4,btn5,btn6);
                txtResult.setText("Winner!");
                DisableButton(false);
                ResetAfterDelay(2000);

            } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
                //3
                changeColor(btn7,btn8,btn9);
                txtResult.setText("Winner!");
                DisableButton(false);
                ResetAfterDelay(2000);

            } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
                //4
                changeColor(btn1,btn4,btn7);
                txtResult.setText("Winner!");
                DisableButton(false);
                ResetAfterDelay(2000);

            } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
                //5
                changeColor(btn2,btn5,btn8);
                txtResult.setText("Winner!");
                DisableButton(false);
                ResetAfterDelay(2000);
            } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
                //6
                changeColor(btn3,btn6,btn9);
                txtResult.setText("Winner!");
                DisableButton(false);
                ResetAfterDelay(2000);

            } else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
                //7
                changeColor(btn1,btn5,btn9);
                txtResult.setText("Winner!");
                DisableButton(false);
                ResetAfterDelay(2000);
            } else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {
                //8
                changeColor(btn3,btn5,btn7);
                txtResult.setText("Winner!");
                DisableButton(false);
                ResetAfterDelay(2000);

            }else if(count==9){
                Draw(btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9);
                txtResult.setText("Draw!");
                ResetAfterDelay(1000);;

            }

        }
    }
    public void Reset(){
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        flag=0;
        count=0;
        txtResult.setText("");
        ResetColor(btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9);
        DisableButton(true);
    }
    public void ResetColor(Button ...v){
        for(int i=0;i<v.length;i++){
            v[i].setBackgroundColor(Color.parseColor("#EBE4E4"));
        }
    }
    public void Draw(Button ...v){
        for(int i=0;i<v.length;i++){
            v[i].setBackgroundColor(Color.parseColor("#FD0000"));
        }
    }
    public void changeColor(Button ...v){
        for(int i=0;i<v.length;i++){
            v[i].setBackgroundColor(Color.parseColor("#63EF68"));
        }
    }
    public void DisableButton(boolean enable){
        btn1.setClickable(enable);
        btn2.setClickable(enable);
        btn3.setClickable(enable);
        btn4.setClickable(enable);
        btn5.setClickable(enable);
        btn6.setClickable(enable);
        btn7.setClickable(enable);
        btn8.setClickable(enable);
        btn9.setClickable(enable);

    }
    public void ResetAfterDelay(long delay){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            Reset();
            }
        },delay);
    }


}