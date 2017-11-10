package com.numeroeins.uniflea.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.numeroeins.uniflea.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.buttonSignIn)
    Button buttonSignIn;
    @BindView(R.id.buttonSignUp)
    Button buttonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);


        buttonSignIn.setOnClickListener(this);
        buttonSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonSignIn:
                Intent signInIntent=new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(signInIntent);
                break;
            case R.id.buttonSignUp:
                Intent signUpIntent=new Intent(WelcomeActivity.this, DashboardActivity.class);
                startActivity(signUpIntent);
                break;

        }
    }
}
