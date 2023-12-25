package com.example.admincollegeapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.admincollegeapp.faculty.UpdateFaculty;
import com.example.admincollegeapp.notice.DeleteNoticeActivity;
import com.example.admincollegeapp.notification.MainNotification;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout uploadNotice, addGalleryImage, addEbook, faculty, deleteNotice, logOut;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private CardView notificationPage;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationPage = findViewById(R.id.notificationClick);
        uploadNotice  = findViewById(R.id.addNotice);
        addGalleryImage = findViewById(R.id.addGalleryImage);
        addEbook = findViewById(R.id.addEbook);
        faculty = findViewById(R.id.faculty);
        deleteNotice = findViewById(R.id.deleteNotice);
        logOut = findViewById(R.id.logout);

        notificationPage.setOnClickListener(this);
        uploadNotice.setOnClickListener(this);
        addGalleryImage.setOnClickListener(this);
        addEbook.setOnClickListener(this);
        faculty.setOnClickListener(this);
        deleteNotice.setOnClickListener(this);
        logOut.setOnClickListener(this);


        //this shared Preference for LoginActivity

        sharedPreferences = this.getSharedPreferences("login",MODE_PRIVATE);
        editor = sharedPreferences.edit();

        if (sharedPreferences.getString("isLogin", "false").equals("false")){
            openLogin();
        }
    }

    @Override
    public void onClick(View view) {

        notificationPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainNotification.class );
                startActivity(intent);
            }
        });

        uploadNotice.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Start new activity
                Intent intent = new Intent(MainActivity.this, com.example.admincollegeapp.notice.uploadNotice.class);
                startActivity(intent);
            }
        });

        addGalleryImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Start new activity
                Intent intent = new Intent(MainActivity.this, UploadImage .class);
                startActivity(intent);
            }
        });

        addEbook.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Start new activity
                Intent intent = new Intent(MainActivity.this, uploadPdfActivity .class);
                startActivity(intent);
            }
        });

        faculty.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Start new activity
                Intent intent = new Intent(MainActivity.this, UpdateFaculty.class);
                startActivity(intent);
            }
        });

        deleteNotice.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Start new activity
                Intent intent = new Intent(MainActivity.this, DeleteNoticeActivity.class);
                startActivity(intent);
            }
        });

        logOut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Start new activity
                editor.putString("isLogin","false");
                editor.commit();
                openLogin();
                Toast.makeText(MainActivity.this, "Logout...", Toast.LENGTH_LONG).show();

            }
        });

        }

    private void openLogin() {
        startActivity(new Intent(MainActivity.this,LoginActivity.class));
        finish();
        }

    }
