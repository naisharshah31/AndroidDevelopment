package com.example.fragment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.Package;

public class MainActivity extends AppCompatActivity {

    private FrameLayout fragcont;
    private ImageButton b1,b2,b3,b4;
    public static String PACKAGE_NAME;
    String winter = "Winter";
    String summer = "Summer";
    String Rainy = "Rainy";
    String Autumn = "Autumn";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragcont = (FrameLayout)findViewById(R.id.fragment_container);
        b1 = (ImageButton)findViewById(R.id.ib1);
        b2 = (ImageButton)findViewById(R.id.ib2);
        b3 = (ImageButton)findViewById(R.id.ib3);
        b4 = (ImageButton)findViewById(R.id.ib4);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String winterid = "winter3";
                PACKAGE_NAME = getApplicationContext().getPackageName();
                int resID = getResources().getIdentifier(winterid , "drawable",PACKAGE_NAME) ;
                openfragment(resID,winter);
                Toast.makeText(MainActivity.this, "You tapped on Winter",Toast.LENGTH_SHORT).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String summerid = "summer3";
                PACKAGE_NAME = getApplicationContext().getPackageName();
                int resID = getResources().getIdentifier(summerid , "drawable",PACKAGE_NAME) ;
                openfragment(resID,summer);
                Toast.makeText(MainActivity.this, "You tapped on Summer",Toast.LENGTH_SHORT).show();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String winterid = "rainy2";
                PACKAGE_NAME = getApplicationContext().getPackageName();
                int resID = getResources().getIdentifier(winterid , "drawable",PACKAGE_NAME) ;
                openfragment(resID,Rainy);
                Toast.makeText(MainActivity.this, "You tapped on Rainy",Toast.LENGTH_SHORT).show();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String winterid = "autum2";
                PACKAGE_NAME = getApplicationContext().getPackageName();
                int resID = getResources().getIdentifier(winterid , "drawable",PACKAGE_NAME) ;
                openfragment(resID,Autumn);
                Toast.makeText(MainActivity.this, " You tapped on Autumn",Toast.LENGTH_SHORT).show();
            }
        });
    }



    private void openfragment(int resID,String txt) {
        ImageFragment fragment = ImageFragment.newInstance(resID,txt);
        FragmentManager  fragmentmanager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentmanager.beginTransaction();
        transaction.addToBackStack(null);
        transaction.add(R.id.fragment_container,fragment,"Image_Fragment").commit();
    }


}
