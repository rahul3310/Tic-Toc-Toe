package com.example.tictoctoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    TextView txtToc,txtTic,txtToe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        txtTic=findViewById(R.id.txtTic);
        txtToc=findViewById(R.id.txtToc);
        txtToe=findViewById(R.id.txtToe);

        Animation move = AnimationUtils.loadAnimation(this,R.anim.move);
        txtToc.setAnimation(move);
        Animation move1 = AnimationUtils.loadAnimation(this,R.anim.scale);
        txtTic.setAnimation(move1);
        Animation move2 = AnimationUtils.loadAnimation(this,R.anim.scale);
        txtToe.setAnimation(move2);

       Intent home = new Intent(SplashActivity.this, LayoutHolderActivity.class);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(home);
                finish();
            }
        },4000);
    }
}