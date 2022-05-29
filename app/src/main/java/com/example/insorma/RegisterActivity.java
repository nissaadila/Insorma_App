package com.example.insorma;
import static com.example.insorma.MainActivity.User;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    EditText emailAddress,username, password,phoneNumber;
    Button btnRegis, btnLogin;
    int idUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        emailAddress = findViewById(R.id.editTextEmailAddress);
        username = findViewById(R.id.editTextUsername);
        phoneNumber = findViewById(R.id.editTextPhoneNumber);
        password = findViewById(R.id.editTextPassword);

        btnRegis = findViewById(R.id.btnRegis);
        btnRegis.setOnClickListener(this);

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnLogin){
            Intent pindahHalaman = new Intent(this,MainActivity.class);
            startActivity(pindahHalaman);
        }
        else if (view.getId() == R.id.btnRegis){
                if(validasiDataInputan()){
                    idUser = User.size()+1;
                    User.add(new UserInSorma(idUser,username.getText().toString(),
                            emailAddress.getText().toString(),phoneNumber.getText().toString(),
                            password.getText().toString()));
                    Intent bawaData = new Intent(this,MainActivity.class);
                    startActivity(bawaData);
                }
        }

    }

    private boolean validasiDataInputan(){
        if(emailAddress.getText().toString().length()==0){
            emailAddress.requestFocus();
            emailAddress.setError("Email harus di isi");
            return false;
        }
        if(!emailAddress.getText().toString().endsWith(".com")){
            emailAddress.requestFocus();
            emailAddress.setError("Harus diakhiri dengan .com");
            return false;
        }
        if(username.getText().toString().length()==0){
            username.requestFocus();
            username.setError("Username harus diisi");
            return false;
        }
        if(!(username.getText().toString().length()>=3 && username.getText().toString().length()<=20)){
            username.requestFocus();
            username.setError("Username harus mengandung 3-20 kata");
            return false;
        }
        if(phoneNumber.getText().toString().length()==0){
            phoneNumber.requestFocus();
            phoneNumber.setError("Phone Number harus diisi");
            return false;
        }
        if(password.getText().toString().length()==0){
            password.requestFocus();
            password.setError("Password harus diisi");
            return false;
        }
        if(!password.getText().toString().matches("^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9]+$")){
            password.requestFocus();
            password.setError("Password harus mengandung angka dan huruf");
        }
        if(User.size() > 0){
            for(Integer data = 0; data<MainActivity.User.size();data++){
                if( User.get(data).getUserEmailAddress().equals(emailAddress.getText().toString())){
                    emailAddress.requestFocus();
                    emailAddress.setError("Email harus unikk");
                    return false;
                }

                else if((User.get(data).getUserName().equals(username.getText().toString()))){
                    username.requestFocus();
                    username.setError("Username harus unikk");
                    return false;
                }

            }

        }
        return true;
    }

}