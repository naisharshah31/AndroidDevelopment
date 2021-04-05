package com.example.cat2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    private ImageButton mbtnWebsite, mbtnCall, mbtnLocation, mbtnbtnMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mbtnWebsite = findViewById(R.id.btnWebsite);
        mbtnCall = findViewById(R.id.btnCall);
        mbtnLocation = findViewById(R.id.btnLocation);
        mbtnbtnMail = findViewById(R.id.btnMail);

        mbtnWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(HomeActivity.this, "Redirecting to website", Toast.LENGTH_SHORT).show();
                String url =  "http://newtreat.co.in/";
                Uri webpage = Uri.parse(url);

                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }else{
                    Log.d("ImplicitIntents", "Can't handle this intent!");
                }
            }
        });

        mbtnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(HomeActivity.this, "Call button clicked", Toast.LENGTH_SHORT).show();
                String contactNum =  "9033661144";

                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + contactNum));

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }else{
                    Log.d("ImplicitIntents", "Can't handle this intent!");
                }
            }
        });

        mbtnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(HomeActivity.this, "Navigating Maps", Toast.LENGTH_SHORT).show();
                String location =  "Amul ice cream parlour #54th cross Rajajinagar Bangalore ";

                Uri addressUri = Uri.parse("geo:0,0?q=" + location);
                Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }else{
                    Log.d("ImplicitIntents", "Can't handle this intent!");
                }
            }
        });

        mbtnbtnMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(HomeActivity.this, "Redirecting to Email", Toast.LENGTH_SHORT).show();
                String subject = "Greetings!!";
                String[] sendTo = new String[] {"chandanabramesh@gmail.com", "saichandanamay13@gmail.com", "latharameshbellamkonda@gmail.com"};
                String content = "Good Morning user this is test mail!!";
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_EMAIL, sendTo);
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, content);
                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }else{
                    Log.d("ImplicitIntents", "Can't handle this intent!");
                }
            }
        });
    }
}