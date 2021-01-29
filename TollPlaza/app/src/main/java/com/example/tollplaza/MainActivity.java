package com.example.tollplaza;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Never modified so declared as final
    private final int twoWheeler_amt = 100;
    private final int fourWheeler_amt = 200;
    private final int truck_bus_amt = 400;
    private final int vip_pass_amt = 0;
    private final int rfid_amt = 50;
    private int vehicle_count = 0, amtCount = 0;

    //Widgets Declaration
    private TextView mCountVehicle, mCountAmt;
    private Button twoWheeler, fourWheeler, rfid, truckBus, vipPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Linking Widgets
        mCountVehicle = findViewById(R.id.vehicle_count);
        mCountAmt = findViewById(R.id.amt_count);

        twoWheeler = findViewById(R.id.two_wheeler_button);
        fourWheeler = findViewById(R.id.four_wheeler_button);
        rfid = findViewById(R.id.rfid_button);
        truckBus = findViewById(R.id.truck_button);
        vipPass = findViewById(R.id.vip_button);


        twoWheeler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vehicle_count += 1;
                amtCount += twoWheeler_amt;
                if (mCountVehicle != null) {
                    display(v, amtCount);
                }
            }
        });

        fourWheeler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vehicle_count += 1;
                amtCount += fourWheeler_amt;
                if (mCountVehicle != null) {
                    display(v, amtCount);
                }
            }
        });

        rfid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vehicle_count += 1;
                amtCount += rfid_amt;
                if (mCountVehicle != null) {
                    display(v, amtCount);
                }
            }
        });

        truckBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vehicle_count += 1;
                amtCount += truck_bus_amt;
                if (mCountVehicle != null) {
                    display(v, amtCount);
                }
            }
        });

        vipPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vehicle_count += 1;
                amtCount += 0;
                if (mCountVehicle != null) {
                    display(v, amtCount);
                }
            }
        });

    }

    //Every time we have to display so created one function to avoid Repetition of code
    private void display(View v, int amount) {
        mCountVehicle.setText(Integer.toString(vehicle_count));
        mCountAmt.setText(Integer.toString(amtCount));
    }
}