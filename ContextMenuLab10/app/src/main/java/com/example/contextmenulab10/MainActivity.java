package com.example.contextmenulab10;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private ImageButton mDelhi, mAgra, mMumbai, mNewYork;
    String choosed = "";
    String dateSelected = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialization
        mDelhi = findViewById(R.id.delhi_button);
        mAgra = findViewById(R.id.agra_button);
        mMumbai = findViewById(R.id.mumbai_button);
        mNewYork = findViewById(R.id.new_york_button);


        registerForContextMenu(mDelhi);
        registerForContextMenu(mAgra);
        registerForContextMenu(mMumbai);
        registerForContextMenu(mNewYork);


    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        dateSelected = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        Toast.makeText(this, "Reservation Selected for " + choosed + " \n On Date: " + dateSelected , Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        //Getting the value which city is long pressed
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
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "Date Picker");
                return true;
            case R.id.visit:
                Toast.makeText(this, "Visit Selected for " + choosed, Toast.LENGTH_SHORT).show();
                visit();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    public void visit() {
        switch (choosed) {
            case "Delhi":
                openWebsite("http://www.delhitourism.gov.in/delhitourism/index.jsp");
                break;
            case "Agra":
                openWebsite("https://www.tourism-of-india.com/agra/");
                break;
            case "Mumbai":
                openWebsite("https://www.maharashtratourism.gov.in/destination/mumbai");
                break;
            case "New york city":
                openWebsite("https://www.nycgo.com/");
                break;

        }
    }

    //Function to open Intent
    private void openWebsite(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        // Find an activity to hand the intent and start that activity.
        startActivity(intent);
    }

}