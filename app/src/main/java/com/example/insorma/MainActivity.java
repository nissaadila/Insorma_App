package com.example.insorma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText emailAddress, password;
    Button btnLogin, btnRegis;

    public static ArrayList<UserInSorma> User = new ArrayList<UserInSorma>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailAddress = findViewById(R.id.editTextEmailAddress);
        password = findViewById(R.id.editTextPassword);

        btnRegis = findViewById(R.id.btnRegis);
        btnRegis.setOnClickListener(this);

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnRegis) {
            Intent pindahHalaman = new Intent(this, RegisterActivity.class);
            startActivity(pindahHalaman);
        } else if (view.getId() == R.id.btnLogin) {
            if (emailAddress.getText().toString().isEmpty()) {
                emailAddress.requestFocus();
                emailAddress.setError("Email harus di isi");

            } else if (password.getText().toString().isEmpty()) {
                password.requestFocus();
                password.setError("Password harus diisi");

            }
            else {
                for(int data=0; data<User.size();data++){
                    if (emailAddress.getText().toString().equals(User.get(data).userEmailAddress) && password.getText().toString().equals(User.get(data).userPassword)){
                        Intent pindahhalaman = new Intent(this,HomePage.class);
                        pindahhalaman.putExtra("User",User.get(data).userName);
                        startActivity(pindahhalaman);
                        break;
                    }
                    else {
                        password.requestFocus();
                        password.setError("Input email dan password tidak sesuai");

                    }

                }

            }

        }

    }
}
