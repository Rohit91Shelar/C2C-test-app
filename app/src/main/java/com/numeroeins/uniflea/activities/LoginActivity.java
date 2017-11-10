package com.numeroeins.uniflea.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.numeroeins.uniflea.R;
import com.numeroeins.uniflea.network.Connection;
import com.numeroeins.uniflea.network.ResponseCallback;
import com.numeroeins.uniflea.utility.AppPreferences;
import com.numeroeins.uniflea.utility.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    @BindView(R.id.editEmail)
    EditText editEmail;
    @BindView(R.id.editPassword)
    EditText editPassword;
    @BindView(R.id.buttonSignIn)
    Button buttonLogin;
    @BindView(R.id.didntHaveAccount)
    TextView textSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        buttonLogin.setOnClickListener(this);
        textSignUp.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonSignIn:
                if (editEmail.getText().toString().length() == 0)
                    Toast.makeText(this, "Please Enter Email Id or Username", Toast.LENGTH_SHORT).show();
                else if (editPassword.getText().toString().length() == 0)
                    Toast.makeText(this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                else {

                    String email = editEmail.getText().toString();
                    String password = editPassword.getText().toString();

                    Connection
                            .with(this, Constants.LOGIN_API)
                            .addParameter("email", email)
                            .addParameter("password", password)
                            .performNetworkCall(new ResponseCallback() {
                                @Override
                                public void onSuccess(JsonObject jsonObject) {
                                    if (jsonObject.get("status").getAsString().equals("Success")) {
                                        Toast.makeText(LoginActivity.this, jsonObject.get("name").getAsString(), Toast.LENGTH_SHORT).show();
                                        AppPreferences.setMemberId(LoginActivity.this, jsonObject.get("member_id").getAsString());
                                        Intent dashboardIntent = new Intent(LoginActivity.this, DashboardActivity.class);
                                        startActivity(dashboardIntent);
                                    } else {
                                        Toast.makeText(LoginActivity.this, jsonObject.get("message").getAsString(), Toast.LENGTH_SHORT).show();
                                    }
                                }

                                @Override
                                public void onFailure(String error) {

                                }
                            }, true);

                }
                break;
            case R.id.didntHaveAccount:
                Intent signUpIntent=new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(signUpIntent);
                break;

            case R.id.buttonCancel:
                finish();
                break;
        }

    }
}
