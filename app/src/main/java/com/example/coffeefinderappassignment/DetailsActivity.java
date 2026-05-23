package com.example.coffeefinderappassignment;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailsActivity extends AppCompatActivity {

    private TextView tvShopName;
    private TextView tvAddress;
    private ImageView ivShopImage;
    private Button btnOpenWebsite;

    private String selectedUrl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setIcon(R.mipmap.ic_launcher);
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvShopName = findViewById(R.id.tvShopName);
        tvAddress = findViewById(R.id.tvAddress);
        ivShopImage = findViewById(R.id.ivShopImage);
        btnOpenWebsite = findViewById(R.id.btnOpenWebsite);

        int shopIndex = getIntent().getIntExtra("shopIndex", -1);

        switch (shopIndex) {
            case 0:
                tvShopName.setText(R.string.tvShopOneName);
                tvAddress.setText(R.string.tvShopOneAddress);
                ivShopImage.setImageResource(R.drawable.shop_one_logo);
                selectedUrl = getString(R.string.tvShopOneURL);
                break;

            case 1:
                tvShopName.setText(R.string.tvShopTwoName);
                tvAddress.setText(R.string.tvShopTwoAddress);
                ivShopImage.setImageResource(R.drawable.shop_two_logo);
                selectedUrl = getString(R.string.tvShopTwoURL);
                break;

            case 2:
                tvShopName.setText(R.string.tvShopThreeName);
                tvAddress.setText(R.string.tvShopThreeAddress);
                ivShopImage.setImageResource(R.drawable.shop_three_logo);
                selectedUrl = getString(R.string.tvShopThreeURL);
                break;

            case 3:
                tvShopName.setText(R.string.tvShopFourName);
                tvAddress.setText(R.string.tvShopFourAddress);
                ivShopImage.setImageResource(R.drawable.shop_four_logo);
                selectedUrl = getString(R.string.tvShopFourURL);
                break;

            default:
                tvShopName.setText("Unknown Coffee Shop");
                tvAddress.setText("Address not available");
                ivShopImage.setImageResource(R.drawable.ic_launcher_foreground);
                selectedUrl = "https://www.google.com/maps";
                break;
        }
    }
}