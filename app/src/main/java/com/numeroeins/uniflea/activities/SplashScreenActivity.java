package com.numeroeins.uniflea.activities;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;

import com.numeroeins.uniflea.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        startThread();
    }


    private void startThread(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                //TODO - start activity

            }
        }).start();
    }
}
