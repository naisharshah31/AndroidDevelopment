package com.example.contextmenulab10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import android.view.ContextMenu;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    private ImageButton mDelhi, mAgra, mMumbai, mNewYork;
    String choosed = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDelhi = findViewById(R.id.delhi_button);
        mAgra = findViewById(R.id.agra_button);
        mMumbai = findViewById(R.id.mumbai_button);
        mNewYork = findViewById(R.id.new_york_button);

        registerForContextMenu(mDelhi);
        registerForContextMenu(mAgra);
        registerForContextMenu(mMumbai);
        registerForContextMenu(mNewYork);

        /*mDelhi.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {


                return true;
            }
        });

        mNewYork.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {


                return true;
            }
        });

        mMumbai.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {


                return true;
            }
        });
        mAgra.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {


                return true;
            }
        });*/
    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);


        switch (v.getId()) {
            case R.id.delhi_button:
                choosed = "Delhi";
                getMenuInflater().inflate(R.menu.city_menu, menu);
                return;

            case R.id.agra_button:
                choosed = "Agra";
                getMenuInflater().inflate(R.menu.city_menu, menu);
                return;

            case R.id.mumbai_button:
                choosed = "Mumbai";
                getMenuInflater().inflate(R.menu.city_menu, menu);
                return;

            case R.id.new_york_button:
                choosed = "New york city";
                getMenuInflater().inflate(R.menu.city_menu, menu);
        }
    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.reservation:
                Toast.makeText(this, "Reservation Selected", Toast.LENGTH_SHORT).show();
            case R.id.visit:
                Toast.makeText(this, "Visit Selected", Toast.LENGTH_SHORT).show();
            default:
                return super.onContextItemSelected(item);
        }
    }

}