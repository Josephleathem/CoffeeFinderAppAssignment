package com.example.coffeefinderappassignment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * Entry screen that lists coffee shops and routes the user to the details screen.
 *
 * Contract note:
 * The clicked list position is passed as the "shopIndex" extra to DetailsActivity,
 * where that index is used to select strings/images.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
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

        // Keep this order aligned with the switch cases in DetailsActivity.
        String[] coffeeShops = {
                "Our Town Roast",
                "Vibe Coffeehouse and Cafe",
                "Dunkin’",
                "The Meeting Place on Market"
        };

        ListView listCoffeeShops = findViewById(R.id.listCoffeeShops);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                coffeeShops
        );
        listCoffeeShops.setAdapter(adapter);

        listCoffeeShops.setOnItemClickListener((parent, view, position, id) -> {
            // Navigate by explicit class name and pass the selected row index.
            Intent intent = new Intent();
            intent.setClassName(this, getPackageName() + ".DetailsActivity");
            intent.putExtra("shopIndex", position);
            startActivity(intent);
        });
    }
}