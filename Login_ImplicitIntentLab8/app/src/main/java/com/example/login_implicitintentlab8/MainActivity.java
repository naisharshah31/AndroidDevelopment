package com.example.login_implicitintentlab8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    //Decaleration
    private final String user = "naishar_shah", pass = "naishar";
    private Button mLogin;
    private TextInputEditText mUsername , mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsername = findViewById(R.id.username);
        mPassword = findViewById(R.id.password);

        mLogin = findViewById(R.id.login_button);


        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = mUsername.getText().toString();
                String password = mPassword.getText().toString();

                if ( username.matches(user) && password.matches(pass) ) {
                    //Create new intent and transfer control to that activity

                    Intent myIntent = new Intent(MainActivity.this,  features.class);
                    MainActivity.this.startActivity(myIntent);

                } else {

                    Toast.makeText(MainActivity.this, "Wrong Username or Password ", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }
}