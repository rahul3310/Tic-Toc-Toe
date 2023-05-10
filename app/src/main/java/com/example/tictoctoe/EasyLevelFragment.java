package com.example.tictoctoe;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class EasyLevelFragment extends Fragment {
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,reset;
    String b1,b2,b3,b4,b5,b6,b7,b8,b9;
    TextView txt;
    int count=0;
    int winner = 0;
    int flag=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View view= inflater.inflate(R.layout.fragment_easy_level, container, false);
       find(view);

       return view;
    }
    private void find(View view){
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
        txt = view.findViewById(R.id.txt);
    }
    public void Check(View view) {
        Button btnCur = (Button) view;

        if (btnCur.getText().toString().equals("")) {
            count++;
            if (flag== 0) {
                btnCur.setText("X");
                flag = 1;

            } else {
                btnCur.setText("O");
                flag = 0;

            }
            if (count > 4) {
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
                    txt.setText("Winner!");
                    DisableButton(false);
                    ResetAfterDelay(2000);
                } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
                    //2
                    changeColor(btn4,btn5,btn6);
                    txt.setText("Winner!");
                    DisableButton(false);
                    ResetAfterDelay(2000);

                } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
                    //3
                    changeColor(btn7,btn8,btn9);
                    txt.setText("Winner!");
                    DisableButton(false);
                    ResetAfterDelay(2000);

                } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
                    //4
                    changeColor(btn1,btn4,btn7);
                    txt.setText("Winner!");
                    DisableButton(false);
                    ResetAfterDelay(2000);

                } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
                    //5
                    changeColor(btn2,btn5,btn8);
                    txt.setText("Winner!");
                    DisableButton(false);
                    ResetAfterDelay(2000);
                } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
                    //6
                    changeColor(btn3,btn6,btn9);
                    txt.setText("Winner!");
                    DisableButton(false);
                    ResetAfterDelay(2000);

                } else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
                    //7
                    changeColor(btn1,btn5,btn9);
                    txt.setText("Winner!");
                    DisableButton(false);
                    ResetAfterDelay(2000);
                } else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {
                    //8
                    changeColor(btn3,btn5,btn7);
                    txt.setText("Winner!");
                    DisableButton(false);
                    ResetAfterDelay(2000);

                }else if(count==9){
                    Draw(btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9);
                    txt.setText("Draw!");
                    ResetAfterDelay(1000);;

                }

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
        txt.setText("");
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
