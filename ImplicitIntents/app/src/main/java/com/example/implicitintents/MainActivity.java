package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button mWebsiteButton, mLocationButton, mShareTextButtton;
    private EditText mWebsiteEditText, mLocationEditText, mShareEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing Widgets
        mWebsiteButton = findViewById(R.id.open_website_button);
        mLocationButton = findViewById(R.id.open_location_button);
        mShareTextButtton = findViewById(R.id.share_text_button);

        mWebsiteEditText =  findViewById(R.id.website_edittext);
        mLocationEditText =  findViewById(R.id.location_edittext);
        mShareEditText =  findViewById(R.id.share_edittext);

        mWebsiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = mWebsiteEditText.getText().toString();
                Uri webpage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                // Find an activity to hand the intent and start that activity.
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Log.d("ImplicitIntents", "Can't handle this intent!");
                }
            }
        });

        mLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loc = mLocationEditText.getText().toString();
                Uri addressUri = Uri.parse("geo:0,0?q=" + loc);

                Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

                // Find an activity to handle the intent, and start that activity.
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Log.d("ImplicitIntents", "Can't handle this intent!");
                }
            }
        });

        mShareTextButtton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String txt = mShareEditText.getText().toString();
                String mimeType = "text/plain";

                ShareCompat.IntentBuilder
                        .from(MainActivity.this)
                        .setType(mimeType)
                        .setChooserTitle(R.string.button_share)
                        .setText(txt)
                        .startChooser();


            }
        });

    }
}