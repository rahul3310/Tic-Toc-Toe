package com.example.tictoctoe;

import android.graphics.Color;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MediumLevelFragment extends Fragment implements View.OnClickListener {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16,reset;
    ImageView backBtnImg ;
    String b1, b2, b3, b4, b5, b6, b7, b8, b9,b10,b11,b12,b13,b14,b15,b16;
    TextView txtResult;
    int count = 0;
    int winner = 0;
    int flag = 0;

    public MediumLevelFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_medium_level, container, false);
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
                btn10.setText("");
                btn11.setText("");
                btn12.setText("");
                btn13.setText("");
                btn14.setText("");
                btn15.setText("");
                btn16.setText("");
                flag=0;
                count=0;
                txtResult.setText("");
                ResetColor(btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16);
                DisableButton(true);
            }
        });
        backBtnImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
                dialog.setTitle("Exit Game");
                dialog.setIcon(R.drawable.baseline_exit_to_app_24);
                dialog.setMessage("Are you want to Exit ?");
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
        btn10 = view.findViewById(R.id.btn10);
        btn11 = view.findViewById(R.id.btn11);
        btn12 = view.findViewById(R.id.btn12);
        btn13 = view.findViewById(R.id.btn13);
        btn14 = view.findViewById(R.id.btn14);
        btn15 = view.findViewById(R.id.btn15);
        btn16 = view.findViewById(R.id.btn16);
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
        btn10.setOnClickListener(this);
        btn11.setOnClickListener(this);
        btn12.setOnClickListener(this);
        btn13.setOnClickListener(this);
        btn14.setOnClickListener(this);
        btn15.setOnClickListener(this);
        btn16.setOnClickListener(this);


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
        if(count>5){
            b1 = btn1.getText().toString();
            b2 = btn2.getText().toString();
            b3 = btn3.getText().toString();
            b4 = btn4.getText().toString();
            b5 = btn5.getText().toString();
            b6 = btn6.getText().toString();
            b7 = btn7.getText().toString();
            b8 = btn8.getText().toString();
            b9 = btn9.getText().toString();
            b10 = btn10.getText().toString();
            b11 = btn11.getText().toString();
            b12 = btn12.getText().toString();
            b13 = btn13.getText().toString();
            b14 = btn14.getText().toString();
            b15 = btn15.getText().toString();
            b16 = btn16.getText().toString();

            //conditions
            if (b1.equals(b2) && b2.equals(b3) && b3.equals(b4) && !b1.equals("")) {
                //1
                changeColor(btn1,btn2,btn3,btn4);
                txtResult.setText("Winner!");
                DisableButton(false);
                ResetAfterDelay(2000);
            } else if (b5.equals(65) && b6.equals(b7) && b7.equals(b8) && !b8.equals("")) {
                //2
                changeColor(btn5,btn6,btn7,btn8);
                txtResult.setText("Winner!");
                DisableButton(false);
                ResetAfterDelay(2000);

            } else if (b9.equals(b10) && b10.equals(b11) && b11.equals(b12) && !b9.equals("")) {
                //3
                changeColor(btn9,btn10,btn11,btn12);
                txtResult.setText("Winner!");
                DisableButton(false);
                ResetAfterDelay(2000);

            }
            else if (b13.equals(b14) && b14.equals(b15) && b15.equals(b16) && !b13.equals("")) {
                //3
                changeColor(btn13,btn14,btn15,btn16);
                txtResult.setText("Winner!");
                DisableButton(false);
                ResetAfterDelay(2000);

            }else if (b1.equals(b5) && b5.equals(b9) && b9.equals(b13) && !b1.equals("")) {
                //4
                changeColor(btn1,btn5,btn9,btn13);
                txtResult.setText("Winner!");
                DisableButton(false);
                ResetAfterDelay(2000);

            } else if (b2.equals(b6) && b6.equals(b10) && b10.equals(b14) && !b2.equals("")) {
                //5
                changeColor(btn2,btn5,btn8);
                txtResult.setText("Winner!");
                DisableButton(false);
                ResetAfterDelay(2000);
            } else if (b3.equals(b7) && b7.equals(b11) && b11.equals(b15) && !b3.equals("")) {
                //6
                changeColor(btn3,btn7,btn11,btn15);
                txtResult.setText("Winner!");
                DisableButton(false);
                ResetAfterDelay(2000);

            } else if (b4.equals(b8) && b8.equals(b12) && b12.equals(b16) && !b4.equals("")) {
                //6
                changeColor(btn4,btn8,btn12,btn16);
                txtResult.setText("Winner!");
                DisableButton(false);
                ResetAfterDelay(2000);

            }else if (b1.equals(b6) && b6.equals(b11) && b11.equals(b16) && !b1.equals("")) {
                //7
                changeColor(btn1,btn6,btn11,btn16);
                txtResult.setText("Winner!");
                DisableButton(false);
                ResetAfterDelay(2000);
            } else if (b4.equals(b7) && b7.equals(b10) && b10.equals(b13) && !b4.equals("")) {
                //8
                changeColor(btn4,btn7,btn10,btn13);
                txtResult.setText("Winner!");
                DisableButton(false);
                ResetAfterDelay(2000);

            }else if(count==16){
                Draw(btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16);
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
        btn10.setText("");
        btn11.setText("");
        btn12.setText("");
        btn13.setText("");
        btn14.setText("");
        btn15.setText("");
        btn16.setText("");
        flag=0;
        count=0;
        txtResult.setText("");
        ResetColor(btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16);
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
        btn10.setClickable(enable);
        btn11.setClickable(enable);
        btn12.setClickable(enable);
        btn13.setClickable(enable);
        btn14.setClickable(enable);
        btn15.setClickable(enable);
        btn16.setClickable(enable);

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