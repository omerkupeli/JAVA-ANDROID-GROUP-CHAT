package com.example.grupsms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class SplashActicity extends AppCompatActivity {

    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_acticity);

        findViewById(R.id.splash_kayıt).setOnClickListener(v -> {
            startActivity(new Intent(SplashActicity.this,RegisterActivity.class));
        });

        findViewById(R.id.splash_giris).setOnClickListener(v -> {
            startActivity(new Intent(SplashActicity.this,LoginActivity.class));
        });

        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null){
            startActivity(new Intent(SplashActicity.this,MainActivity.class));
            Toast.makeText(this, "Yönlendiriliyorsunuz", Toast.LENGTH_SHORT).show();
        }
    }
}