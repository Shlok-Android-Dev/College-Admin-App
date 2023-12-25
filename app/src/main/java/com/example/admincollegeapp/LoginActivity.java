package com.example.admincollegeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.material.button.MaterialButton;

public class LoginActivity extends AppCompatActivity {


    private VideoView videoview;

    private EditText userEmail, userPassword;
    private TextView tvShow;
    private MaterialButton loginButton;
    private String email, pass;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        videoview = findViewById(R.id.videoView);

        userEmail = findViewById(R.id.userEmail);
        userPassword = findViewById(R.id.userPassword);
        loginButton = findViewById(R.id.loginButton);
        tvShow = findViewById(R.id.textShow);

        sharedPreferences = this.getSharedPreferences("login",MODE_PRIVATE);
        editor = sharedPreferences.edit();

        if (sharedPreferences.getString("isLogin", "false").equals("yes")){
            openDash();
        }

        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.background);
        videoview.setVideoURI(uri);
        videoview.start();

        tvShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userPassword.getInputType() == 144){
                    userPassword.setInputType(129);
                    tvShow.setText("Hide");
                }else {
                    userPassword.setInputType(144);
                    tvShow.setText("Show");
                }
                userPassword.setSelection(userPassword.getText().length());
            }


        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validateData();

            }
        });

    }


    private void validateData() {
        email = userEmail.getText().toString();
        pass = userPassword.getText().toString();

        if (email.isEmpty()){
            userEmail.setError("Required");
            userEmail.requestFocus();
        }else if (pass.isEmpty()){
            userPassword.setError("Required");
            userPassword.requestFocus();
        } else if (email.equals("adminIPS@gmail.com") && pass.equals("ipsShlok")) {
            editor.putString("isLogin","yes");
            editor.commit();
            openDash();
        }else {
            Toast.makeText(this, "Please check credentials", Toast.LENGTH_LONG).show();
        }
    }

    private void openDash() {
        startActivity(new Intent(LoginActivity.this,MainActivity.class));
        finish();
    }
}