package com.example.fragment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.Package;

public class MainActivity extends AppCompatActivity {

    private FrameLayout fragcont;
    private Button b1,b2,b3,b4;
    public static String PACKAGE_NAME;
    String winter = "Winter";
    String summer = "Summer";
    String Rainy = "Rainy";
    String Autum = "Autumn";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragcont = (FrameLayout)findViewById(R.id.fragment_container);
        b1 = (Button)findViewById(R.id.button);
        b2 = (Button)findViewById(R.id.button1);
        b3 = (Button)findViewById(R.id.button2);
        b4 = (Button)findViewById(R.id.button3);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String winterid = "winter1";
                PACKAGE_NAME = getApplicationContext().getPackageName();
                int resID = getResources().getIdentifier(winterid , "drawable",PACKAGE_NAME) ;
                openfragment(resID,winter);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String summerid = "summer2";
                PACKAGE_NAME = getApplicationContext().getPackageName();
                int resID = getResources().getIdentifier(summerid , "drawable",PACKAGE_NAME) ;
                openfragment(resID,summer);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String winterid = "rainy2";
                PACKAGE_NAME = getApplicationContext().getPackageName();
                int resID = getResources().getIdentifier(winterid , "drawable",PACKAGE_NAME) ;
                openfragment(resID,Rainy);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String winterid = "autum2";
                PACKAGE_NAME = getApplicationContext().getPackageName();
                int resID = getResources().getIdentifier(winterid , "drawable",PACKAGE_NAME) ;
                openfragment(resID,Autum);
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
