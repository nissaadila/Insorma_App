package com.example.insorma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import static com.example.insorma.HomePage.product;

public class FurnitureDetailPage extends AppCompatActivity {
    ImageView detailImage;
    TextView productName,productRating,productPrice;
    EditText quantityProduct;
    Integer idProduk;

    Button buy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_furniture_detail_page);
        detailImage = findViewById(R.id.detailImageView);
        productName = findViewById(R.id.tvProductName);
        productRating = findViewById(R.id.tvRating);
        productPrice = findViewById(R.id.tvPrice);
        quantityProduct = findViewById(R.id.editTextQuantity);
        buy = findViewById(R.id.buttonBuy);


        Intent movee = getIntent();
        idProduk = movee.getIntExtra("ProdukId",0);

        detailImage.setImageResource(HomePage.product.get(idProduk-1).getImage());
        productName.setText(HomePage.product.get(idProduk-1).getProductName());
        productRating.setText(HomePage.product.get(idProduk-1).getRating().toString());
        productPrice.setText(HomePage.product.get(idProduk-1).getPrice());
    }



}