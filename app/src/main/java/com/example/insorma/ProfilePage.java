package com.example.insorma;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import static com.example.insorma.MainActivity.User;


public class ProfilePage extends AppCompatActivity{
    TextView emailAddress, userName, phoneNumber;
    Button edit,save,logOut,deleteAcc;
    int idUser;
    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        emailAddress = findViewById(R.id.tvEmailAddress);
        userName = findViewById(R.id.tvUsername);
        phoneNumber = findViewById(R.id.tvPhoneNumber);

        edit = findViewById(R.id.bEdit);
        save = findViewById(R.id.bSaveChange);
        logOut = findViewById(R.id.bLogOut);
        deleteAcc = findViewById(R.id.bDeleteAcc);

        for(int n = 0 ; n<User.size();n++){
            emailAddress.setText(User.get(n).userEmailAddress);
            userName.setText(User.get(n).userName);
            phoneNumber.setText(User.get(n).userPhoneNumber);
        }


    }
    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menuinsorma, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.home:
                Intent dataHome = new Intent(this, HomePage.class);
                startActivity(dataHome);
                break;
            case R.id.profile:
                break;
        }

        return super.onOptionsItemSelected(item);
    }



}