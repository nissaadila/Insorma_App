package com.example.insorma;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity implements ProductInsormaAdapter.ItemClickListener {
    ImageView imageProduct;
    RecyclerView recyclerViewProductInsorma;
    ProductInsormaAdapter adapter;
    TextView tampilanUsername;
    public static ArrayList<ProductInsorma> product = new ArrayList<ProductInsorma>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        recyclerViewProductInsorma = findViewById(R.id.recyclerViewProductInsorma);
        imageProduct = findViewById(R.id.iViewProduct);
        tampilanUsername = findViewById(R.id.tvUsername);
        Intent pindahhalaman = getIntent();
        String username = pindahhalaman.getStringExtra("User");
        tampilanUsername.setText(username);


        product.add(new ProductInsorma(1,R.drawable.kursimakan,"Kursi",3.3f,300_0000));
        product.add(new ProductInsorma(2,R.drawable.kasur1,"Kasur aesthetix",4.7f,400_0000));
        product.add(new ProductInsorma(3,R.drawable.kasur2,"Kasur lucu",4.5f,450_0000));
        product.add(new ProductInsorma(4,R.drawable.kursi1,"Kursi instagramable",2.3f,320_0000));
        product.add(new ProductInsorma(5,R.drawable.lemari1,"Lemari Kekinian",5f,310_0000));

        recyclerViewProductInsorma.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ProductInsormaAdapter(this,product);
        adapter.setClickListener(this);
        recyclerViewProductInsorma.setAdapter(adapter);


    }
    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menuinsorma, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.home:
                break;
            case R.id.profile:
                Intent dataProfile = new Intent(this, ProfilePage.class);
                startActivity(dataProfile);
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onItemClick(View view, int position) {
       // String produk = adapter.getItem(position).productName;
//        Integer pro = position;
        Intent move = new Intent(HomePage.this,FurnitureDetailPage.class);
        move.putExtra("ProdukId",position);
        startActivity(move);
//        Intent intent = new Intent(HomePage.this,FurnitureDetailPage.class);
//        startActivity(intent);
        //Toast.makeText(this, "You clicked " + adapter.getItem(position).productName + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}