package com.example.menulab9;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;
import androidx.core.content.ContextCompat;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import yuku.ambilwarna.AmbilWarnaDialog;



public class MainActivity extends AppCompatActivity {

    //Declaration
    TextInputEditText mMainMessage, mPhoneNumber;
    RelativeLayout mLayout;
    int defaultColor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialization
        mMainMessage = findViewById(R.id.main_textbox);
        mPhoneNumber = findViewById(R.id.phone_number);


        mLayout = findViewById(R.id.layout);
        defaultColor = ContextCompat.getColor(MainActivity.this, R.color.design_default_color_primary);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.send:
                whatsappSend();
                return true;

            case R.id.color:
                setColor();
                return true;

            case R.id.share:
                share();
                return true;

            case R.id.exit:
                exit();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }


    }

    //Share intent to share the content and open share tray!
    void share() {
        String txt = mMainMessage.getText().toString();
        String mimeType = "text/plain";

        ShareCompat.IntentBuilder
                .from(MainActivity.this)
                .setType(mimeType)
                .setChooserTitle(txt)
                .setText(txt)
                .startChooser();
    }

    //Color Picker
    void setColor() {

        AmbilWarnaDialog ambilWarnaDialog = new AmbilWarnaDialog(this, defaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                defaultColor = color;
                mLayout.setBackgroundColor(defaultColor);
            }
        });
        ambilWarnaDialog.show();

    }

    //Whatsapp intent to share data from our app to whatsapp!
    void whatsappSend() {
        String message = mMainMessage.getText().toString();
        String number = mPhoneNumber.getText().toString();

        if (number.matches("") || (number.length() != 10) ) {
            Toast.makeText(MainActivity.this, "Please enter valid number", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean installed = appInstalledOrNot("com.whatsapp");
        if (installed) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+ "+91"+ number + "&text=" + message));
            startActivity(intent);
        } else {
            Toast.makeText(MainActivity.this, "Whatsapp not instaled", Toast.LENGTH_SHORT).show();
        }

    }



    //Closes the App: Closing current activity
    void exit() {
            finish();
    }

    //Checking whether the app is installed or not!
    private boolean appInstalledOrNot(String url) {
        PackageManager packageManager = getPackageManager();
        boolean app_installed;

        try {
            packageManager.getPackageInfo(url, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        } catch ( PackageManager.NameNotFoundException e ) {
            app_installed = false;
        }

        return app_installed;
    }

}