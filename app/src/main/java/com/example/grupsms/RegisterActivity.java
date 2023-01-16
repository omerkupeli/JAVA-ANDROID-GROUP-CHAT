package com.example.grupsms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    EditText emailEditText,passwordEditText;
    Button registerButton;
    Button loginButton;

    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        emailEditText = findViewById(R.id.register_emailEditText);
        passwordEditText = findViewById(R.id.register_passwordEditText);
        registerButton = findViewById(R.id.register_registerButton);
        loginButton = findViewById(R.id.register_loginButton);

        findViewById(R.id.register_loginButton).setOnClickListener(v -> {
            startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            finish();
        });
        mAuth = FirebaseAuth.getInstance();
        registerButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            if (email.isEmpty() || password.isEmpty()){
                Toast.makeText(RegisterActivity.this, "Lütfen tüm alanları doldurunuz", Toast.LENGTH_SHORT).show();
                return;
            }
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                if(task.isSuccessful()){
                    Toast.makeText(RegisterActivity.this, "Kayıt Başarılı", Toast.LENGTH_SHORT).show();
                    //startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                    finish();
                }
                else{
                    Toast.makeText(RegisterActivity.this, "Kayıt Başarısız", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}