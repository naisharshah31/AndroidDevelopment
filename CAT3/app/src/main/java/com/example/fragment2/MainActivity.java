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
    private Button b1,b2,b3,b4;
    public static String PACKAGE_NAME;
    String ml = "Machine Learning";
    String ai = "Artificial Intelligence";
    String cloud = "Cloud Computing";
    String big_data = "Big Data";
    String d_ml = "21/03/2021";
    String d_ai = "26/03/2021";
    String d_cloud = "20/04/2021";
    String d_big_data = "30/04/2021";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragcont = (FrameLayout)findViewById(R.id.fragment_container);
        b1 = (Button)findViewById(R.id.ml);
        b2 = (Button)findViewById(R.id.ai);
        b3 = (Button)findViewById(R.id.cloud);
        b4 = (Button)findViewById(R.id.big);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = "ml";
                PACKAGE_NAME = getApplicationContext().getPackageName();
                int resID = getResources().getIdentifier(id , "drawable",PACKAGE_NAME) ;
                openfragment(resID,ml,d_ml);
                Toast.makeText(MainActivity.this, "Machine Learning",Toast.LENGTH_SHORT).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = "ai";
                PACKAGE_NAME = getApplicationContext().getPackageName();
                int resID = getResources().getIdentifier(id , "drawable",PACKAGE_NAME) ;
                openfragment(resID,ai,d_ai);
                Toast.makeText(MainActivity.this, "Artificial Intelligence",Toast.LENGTH_SHORT).show();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = "cloud";
                PACKAGE_NAME = getApplicationContext().getPackageName();
                int resID = getResources().getIdentifier(id , "drawable",PACKAGE_NAME) ;
                openfragment(resID,cloud,d_cloud);
                Toast.makeText(MainActivity.this, "Cloud Computing",Toast.LENGTH_SHORT).show();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = "big";
                PACKAGE_NAME = getApplicationContext().getPackageName();
                int resID = getResources().getIdentifier(id , "drawable",PACKAGE_NAME) ;
                openfragment(resID,big_data,d_big_data);
                Toast.makeText(MainActivity.this, " Big Data",Toast.LENGTH_SHORT).show();
            }
        });
//        select.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Selected",Toast.LENGTH_SHORT).show();
//            }
//        });
    }



    private void openfragment(int resID,String txt,String date) {
        ImageFragment fragment = ImageFragment.newInstance(resID,txt,date);
        FragmentManager  fragmentmanager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentmanager.beginTransaction();
        transaction.addToBackStack(null);
        transaction.add(R.id.fragment_container,fragment,"Image_Fragment").commit();
    }

}
