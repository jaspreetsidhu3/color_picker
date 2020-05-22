package com.example.colorpack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(2000);
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        thread.start();
    }
}
